package edu.hunau.service;

import edu.hunau.model.Answer;

import java.util.List;

public interface AnswerService {




    /**
     * 添加一个答案
     * @param answer
     */
    void addAnswer(Answer answer);

    /**
     * 根据question_id获取所有的答案
     * @param questionId
     * @return List Answer
     */
    List<Answer> getAllAnswers(Integer questionId);

    /**
     * 通过answerId删除答案
     * @param answerId
     */
    void deleteAnswer(Integer answerId);

    /**
     * 通过answerId给回答点赞
     * @param answerId
     */
    void addAnswerLike(Integer answerId,Integer userId);

    /**
     * 通过answerId取消给回答点赞
     * @param answerId
     */
    void cancelAnswerLike(Integer answerId);

    /**
     * 查询begin到end条回答
     * @param begin
     * @param end
     * @return
     */
    List<Answer> getAnswerByIndex(Integer begin,Integer end);

    /**
     * 通过question_id获得该问题回答的总数
     * @param questionId
     * @return
     */
    Integer getTotalAnswerNum(Integer questionId);


    Answer getSingleAnswerById(Integer id);



    void addAnswerReadNum(Integer id);


    Boolean getLikeStatus(Integer userId,Integer answerId);


    void cancelLike(Integer userId,Integer answerId);




}
