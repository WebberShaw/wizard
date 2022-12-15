package edu.hunau.controller;


import edu.hunau.model.Answer;
import edu.hunau.model.User;
import edu.hunau.service.AnswerService;
import edu.hunau.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;
    @GetMapping("/{id}")
    public Result getByQuestion(@PathVariable Integer id){
        List<Answer> allAnswers = answerService.getAllAnswers(id);
        return new Result(Code.OK,allAnswers);
    }

    @PostMapping()
    public Result addAnswer(@RequestBody Answer answer, HttpServletRequest request){
        System.out.println(answer);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            return new Result(Code.NOT_LOGIN,false,"请先完成登录再进行此操作");
        }
        int userId = user.getId();
        System.out.println(user+"----------------------------------------------------------");
        answer.setUserId(userId);
        String content = answer.getContent();
        if(content.length()>128){
            answer.setContent(content.substring(0,123)+"...");


        }
        answerService.addAnswer(answer);
        questionService.incraseAnsNum(answer.getQuestionId());


        return new Result(Code.OK,true);
    }

}
