package edu.hunau.service.impl;

import edu.hunau.dao.UserDao;
import edu.hunau.model.User;
import edu.hunau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public User login(User user) {
        User resUser = userDao.getUserByTelAndPassword(user);
        return resUser;
    }
}
