package edu.hunau;

import edu.hunau.dao.AnswerDao;
import edu.hunau.dao.CommentDao;
import edu.hunau.dao.QuestionDao;
import edu.hunau.dao.UserDao;
import edu.hunau.model.Answer;
import edu.hunau.model.Comment;
import edu.hunau.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void contextLoads() {
        Answer answer = new Answer();
        answer.setContent("22");
        answer.setUserId(11);
        answer.setQuestionId(11);

        List<Answer> allAnswers = answerDao.getAllAnswers();
        for (Answer answ : allAnswers
        ) {
            System.out.println(answ);
        }

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
//    }
    }
}
