package edu.hunau.service.impl;

import edu.hunau.model.Answer;
import edu.hunau.service.AnswerService;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {

    @Override
    public void addAnswer(Answer answer) {

    }

    @Override
    public List<Answer> getAllAnswers(Integer questionId) {
        return null;
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
        return null;
    }
}
