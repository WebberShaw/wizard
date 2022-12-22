package edu.hunau.service;

import edu.hunau.model.User;

public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 更新、补全更多用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 用户登录
     * @param user
     * @return User
     */
    User login(User user);


    Boolean checkTele(User user);

    int sendRegisterEmailCode(String to);
    int sendMessageCode(String to,int type);

    User getById(Integer id);


}
