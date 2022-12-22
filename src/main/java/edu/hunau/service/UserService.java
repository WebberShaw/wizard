package edu.hunau.service;

import edu.hunau.model.Answer;
import edu.hunau.model.Question;
import edu.hunau.model.User;

import java.util.List;

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

    List<Answer> getMyAnswers(Integer userId);
    List<Answer> getMyLikedAnswers(Integer userId);

    List<Question> getMyQuestions(Integer userId);




}
