package edu.hunau.controller;

import edu.hunau.model.Question;
import edu.hunau.model.User;
import edu.hunau.service.QuestionService;
import edu.hunau.service.UserService;
import edu.hunau.utils.UserDesensitizationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;
    @GetMapping
    public Result getAllQuestion(){
        List<Question> allQuestions = questionService.getAllQuestions();
        return new Result(Code.OK,allQuestions,"获取成功");
    }

    @GetMapping("/key/{key}")
    public Result serachByKey(@PathVariable String key){
        key="%"+key+"%";
        List<Question> questionByParams = questionService.getQuestionByParams(key);
        return new Result(Code.OK,questionByParams,"获取成功");
    }

    @GetMapping("/id/{id}")
    public Result getById(@PathVariable Integer id){

        Question singleQuestionById = questionService.getSingleQuestionById(id);
        questionService.addReadNum(id);
        System.out.println(singleQuestionById);

        User user = userService.getById(singleQuestionById.getUserId());
        if (user!=null) {
            singleQuestionById.setUser(UserDesensitizationUtil.desensitize(user));
        }else {
            user=new User();
            user.setUsername("该用户不存在");
            singleQuestionById.setUser(user);
        }
        return new Result(Code.OK,singleQuestionById,"获取成功");
    }

    @PostMapping
    public Result addQuestion(@RequestBody Question question, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            return new Result(Code.NOT_LOGIN,false,"请先完成登录再进行此操作");
        }
        question.setUserId(user.getId());
        questionService.addQuestion(question);
        return new Result(Code.OK,true);
    }

}
