package edu.hunau.service.impl;

import edu.hunau.dao.AnswerDao;
import edu.hunau.dao.UserDao;
import edu.hunau.model.Answer;
import edu.hunau.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerDao answerDao;

    @Autowired
    UserDao userDao;

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
    public void addAnswerLike(Integer answerId,Integer userId) {
        answerDao.addLikesById(answerId);
        userDao.likeAnAnswer(userId,answerId);
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

    @Override
    public Answer getSingleAnswerById(Integer id) {
        return answerDao.getById(id);
    }

    @Override
    public void addAnswerReadNum(Integer id) {
        answerDao.addReadNum(id);
    }

    @Override
    public Boolean getLikeStatus(Integer userId, Integer answerId) {
        Object likeStatus = userDao.getLikeStatus(userId, answerId);
        if(likeStatus==null){
            return false;
        }
        return true;
    }

    @Override
    public void cancelLike(Integer userId, Integer answerId) {
        userDao.deleteLikes(userId,answerId);
        answerDao.cancelAddLikes(answerId);
    }
}
