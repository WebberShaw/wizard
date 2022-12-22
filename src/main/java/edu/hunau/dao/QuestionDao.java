package edu.hunau.dao;

import edu.hunau.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface QuestionDao {

    @Select("select title from question where id = #{id}")
    String getQuestionNameById(Integer id);

    /**
     * 添加一个提问
     * @param question
     */
    void addQuestion(Question question);

    /**
     * 删除一个提问
     * @param
     */
    void deleteById(Integer id);

    /**
     * 通过id获得单挑提问
     * @param question_id
     * @return
     */
    Question getQuestionById(Integer question_id);

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
     * @param
     */
//    void collectionByUser(Integer userId);
    void addReadNumById(Integer id);
    void addAnswerNumById(Integer id);
}
