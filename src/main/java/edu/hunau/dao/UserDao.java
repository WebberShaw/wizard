package edu.hunau.dao;

import edu.hunau.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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








}
