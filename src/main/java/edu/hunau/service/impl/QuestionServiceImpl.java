package edu.hunau.service.impl;

import edu.hunau.controller.Result;
import edu.hunau.dao.QuestionDao;
import edu.hunau.model.Question;
import edu.hunau.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;

    @Override
    public String getQuestionNameById(Integer id) {
        return questionDao.getQuestionNameById(id);
    }

    @Override
    public void addReadNum(Integer questionId) {
        questionDao.addReadNumById(questionId);
    }

    @Override
    public void incraseAnsNum(Integer questionId) {
        questionDao.addAnswerNumById(questionId);
    }

    @Override
    public void addQuestion(Question question) {
        questionDao.addQuestion(question);
    }



    @Override
    public void deleteQuestion(Question question) {

    }

    @Override
    public Question getSingleQuestionById(Integer question_id) {

        return questionDao.getQuestionById(question_id);
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> allQuestions = questionDao.getAllQuestions();

        return allQuestions;
    }

    @Override
    public List<Question> getQuestionByParams(String params) {
        return questionDao.getQuestionByParams(params);
    }

    @Override
    public List<Question> getQuestionByIndex(Integer begin, Integer end) {
        return null;
    }
}
