package edu.hunau.dao;

import edu.hunau.model.Answer;
import edu.hunau.model.Question;
import edu.hunau.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 更新、补全更多用户信息
     * @param user
     */
    void update(User user);

    /**
     * 删除用户
     * @param userId
     */

    void deleteUser(Integer userId);

    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select * from user where password = #{password} AND tel=#{tel}")
    User getUserByTelAndPassword(User user);


    /**
     * 检查电话唯一性
     * @param user
     * @return
     */
    @Select("select * from user where tel=#{tel}")
    User getUserByTel(User user);

    User getUserById(Integer id);


    void likeAnAnswer(Integer userId,Integer answerId);


    Object getLikeStatus(Integer userId,Integer answerId);


    void deleteLikes(Integer userId,Integer answerId);

    List<Question> getMyQuestions(Integer userId);

    List<Answer> getMyLikedAnswers(Integer userId);


    List<Answer> getMyAnswers(Integer userId);










}
