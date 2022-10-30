package edu.hunau.service;

import edu.hunau.model.Question;

import java.util.List;

public interface QuestionService {
    void addReadNum(Integer questionId);
    void incraseAnsNum(Integer questionId);
    /**
     * 添加一个提问
     * @param question
     */
    void addQuestion(Question question);

    /**
     * 删除一个提问
     * @param question
     */
    void deleteQuestion(Question question);

    /**
     * 通过id获得单挑提问
     * @param question_id
     * @return
     */
    Question getSingleQuestionById(Integer question_id);

    /**
     * 获取所有提问
     * @return
     */
    List<Question> getAllQuestions();

    /**
     * 根据字段搜索提问
     * @param params
     * @return
     */
    List<Question> getQuestionByParams(String params);

    /**
     * 获取begin到end条数据
     * @param begin
     * @param end
     * @return
     */
    List<Question> getQuestionByIndex(Integer begin,Integer end);



    //后续实现--------------

    /**
     * 得到一个用户收藏的提问
     * @param userId
     * @return
     */

//    List<Question> getQuestionByUser(Integer userId);

    /**
     * 收藏一个提问
     * @param userId
     */
//    void collectionByUser(Integer userId);

}
