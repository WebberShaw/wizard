package edu.hunau.controller;


import edu.hunau.model.Answer;
import edu.hunau.model.User;
import edu.hunau.service.AnswerService;
import edu.hunau.service.QuestionService;
import edu.hunau.service.UserService;
import edu.hunau.utils.UserDesensitizationUtil;
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

    @Autowired
    UserService userService;

    @GetMapping("/id/{id}")
    public Result getById(@PathVariable Integer id){
        Answer answer = answerService.getSingleAnswerById(id);
        if(answer==null){
            return new Result(Code.ERR,null,"该回答不存在");
        }
        answerService.addAnswerReadNum(answer.getId());
        User user = userService.getById(answer.getUserId());
        if (user!=null) {
            answer.setUser(UserDesensitizationUtil.desensitize(user));
        }else {
            user=new User();
            user.setUsername("该用户不存在");
            answer.setUser(user);
        }

        answer.setQuestion(questionService.getSingleQuestionById(answer.getQuestionId()));

        return new Result(Code.OK,answer,"查询成功");

    }

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
        answerService.addAnswer(answer);
        questionService.incraseAnsNum(answer.getQuestionId());


        return new Result(Code.OK,true);
    }


    @PostMapping ("/likes/{answerId}")
    public Result addLikes(@PathVariable Integer answerId,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            return new Result(Code.NOT_LOGIN,null,"您的登录已过期，请重新登录");
        }
        Boolean likeStatus = answerService.getLikeStatus(user.getId(), answerId);
        if(likeStatus){
            return new Result(Code.ERR,null,"你已经点过赞了");
        }
        answerService.addAnswerLike(answerId,user.getId());
        return new Result(Code.OK,null);
    }
    @GetMapping ("/likes/{answerId}")
    public Result getLikeStatus(@PathVariable Integer answerId,HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");

            if(user==null){
                return new Result(Code.OK,false);
            }
            Boolean likeStatus = answerService.getLikeStatus(user.getId(), answerId);
            return new Result(Code.OK,likeStatus);
        } catch (Exception e) {
            return new Result(Code.ERR,false,"查询点赞状态失败");
        }
    }
    @DeleteMapping ("/likes/{answerId}")
    public Result cancelLikeStatus(@PathVariable Integer answerId,HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");

            if(user==null){
                return new Result(Code.NOT_LOGIN,null,"您的登录已过期，请重新登录");
            }
            if(!answerService.getLikeStatus(user.getId(), answerId)){
                return new Result(Code.ERR,null,"您未点赞");
            }
            answerService.cancelLike(user.getId(), answerId);
            return new Result(Code.OK,null);
        } catch (Exception e) {
            return new Result(Code.ERR,null,"取消点赞失败");
        }
    }

}
