package edu.hunau.controller;

import edu.hunau.model.Question;
import edu.hunau.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping
    public Result getAllQuestion(){
        List<Question> allQuestions = questionService.getAllQuestions();
        return new Result(Code.OK,allQuestions,"获取成功");
    }

}
