package edu.hunau;

import edu.hunau.dao.AnswerDao;
import edu.hunau.dao.CommentDao;
import edu.hunau.dao.QuestionDao;
import edu.hunau.dao.UserDao;
import edu.hunau.model.Answer;
import edu.hunau.model.Comment;
import edu.hunau.model.Question;
import edu.hunau.model.User;
import edu.hunau.service.AnswerService;
import edu.hunau.service.UserService;
import edu.hunau.utils.SenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class WizardApplicationTests {
    @Autowired
    AnswerDao answerDao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    QuestionDao questionDao;
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @Autowired
    AnswerService answerService;

    @Autowired
    JavaMailSender javaMailSender;



    @Test
    public void contextLoads() {



        Answer answer = new Answer();
        answer.setContent("22");
        answer.setUserId(11);
        answer.setQuestionId(11);

//        List<Answer> allAnswers = answerDao.getAllAnswers();
//        for (Answer answ : allAnswers
//        ) {
//            System.out.println(answ);
//        }

        //delete
        //   answerDao.deleteById(1);
        //add
        // answerDao.addLikesById(3);
        //cancel
        //    answerDao.cancelAddLikes(3);
//             Comment comment = new Comment();
//            comment.setContent("2332");
//            comment.setUserId(1);
//            comment.setAnswerId(3);
//            commentDao.addComment(comment);
//        List<Comment> allComment = commentDao.getAllComment(2);
//        for (Comment commit:allComment
//             ) {
//            System.out.println(commit);
//        }


//        Question question = new Question();
//        question.setUserId(1);
//        question.setTitle("fg");
//        question.setContent("ga");
//        List<Question> allQuestions = questionDao.getAllQuestions();
//        for (Question questio:allQuestions
//             ) {
//            System.out.println(questio);
//        }
        User user = new User();
        user.setUsername("aa");
        user.setPassword("21414");
        user.setTel("11111");
        user.setEmail("agagaga");
        Answer answer1 = new Answer();
        answer1.setContent("AAA");
        answer1.setUserId(2);
        answer1.setQuestionId(2);
        answerService.addAnswer(answer1);


    }

    @Test
    public void mailTest(){
        System.out.println(userService.sendMessageCode("15367525826", SenderUtil.OTHER_TEXT_MESSAGE_CODE));
    }
}
