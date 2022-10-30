package edu.hunau.service.impl;

import edu.hunau.dao.AnswerDao;
import edu.hunau.model.Answer;
import edu.hunau.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerDao answerDao;

    @Override
    public void addAnswer(Answer answer) {
        answerDao.addAnswer(answer);
    }

    @Override
    public List<Answer> getAllAnswers(Integer questionId) {
        return answerDao.getAllAnswers(questionId);
    }

    @Override
    public void deleteAnswer(Integer answerId) {

    }

    @Override
    public void addAnswerLike(Integer answerId) {

    }

    @Override
    public void cancelAnswerLike(Integer answerId) {

    }

    @Override
    public List<Answer> getAnswerByIndex(Integer begin, Integer end) {
        return null;
    }

    @Override
    public Integer getTotalAnswerNum(Integer questionId) {
        return answerDao.getTotalAnswerNum(questionId);
    }
}
