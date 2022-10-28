package edu.hunau;

import edu.hunau.dao.AnswerDao;
import edu.hunau.model.Answer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WizardApplicationTests {
    @Autowired
    AnswerDao answerDao;
    @Test
    void contextLoads() {
        Answer answer = new Answer();
        answer.setQuestionId(1);
        answer.setContent("hhhhhh");
        answer.setUser_id(1);
        answerDao.addAnswer(answer);
    }

}
