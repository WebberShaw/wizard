package edu.hunau.dao;

import edu.hunau.model.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerDao {
    /**
     * 添加一个答案
     * @param answer
     */
    void addAnswer(Answer answer);

    /**
     * 根据question_id获取所有的答案
     *
     * @return List Answer
     */
    List<Answer> getAllAnswers();

    /**
     * 通过answerId删除答案
     * @param answerId
     */
    void deleteById(Integer answerId);

    /**
     * 通过answerId给回答点赞
     * @param answerId
     */
    void addLikesById(Integer answerId);

    /**
     * 通过answerId取消给回答点赞
     * @param answerId
     */
    void cancelAddLikes(Integer answerId);

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




}
