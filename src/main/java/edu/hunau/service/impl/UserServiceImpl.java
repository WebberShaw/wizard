package edu.hunau.service.impl;

import edu.hunau.dao.UserDao;
import edu.hunau.model.User;
import edu.hunau.service.UserService;
import edu.hunau.utils.SenderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    SenderUtil senderUtil;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public User login(User user) {
        User resUser = userDao.getUserByTelAndPassword(user);
        return resUser;
    }

    @Override
    public Boolean checkTele(User user) {
        return userDao.getUserByTel(user)==null;
    }

    @Override
    public int sendRegisterEmailCode(String to) {
        int code = (int) (Math.random()*1000000+1);
        String  text = "您好感谢您注册Wizard鬼才，您的注册验证码是：\n\t" + code
                + "\n请您务必保管好您的验证码，如有问题，您可以直接回复此邮件，我们将竭诚为您服务。" +
                "\n若您对注册行为并不知情，请忽略该邮件";
        String subject = "[Wizard]欢迎使用，您的注册验证码";
        if(!senderUtil.sendEmail(to, subject, text)){
            return 0;
        }

        return code;
    }


    @Override
    public int sendMessageCode(String to,int type) {
        int code = (int) (Math.random()*1000000+1);
        if(!senderUtil.sendTextMessage(to,code,SenderUtil.REGISTER_TEXT_MESSAGE_CODE)){
            return 0;
        }

        return code;
    }


}
