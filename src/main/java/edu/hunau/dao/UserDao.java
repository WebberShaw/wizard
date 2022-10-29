package edu.hunau.dao;

import edu.hunau.model.User;
import org.apache.ibatis.annotations.Mapper;

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


}
