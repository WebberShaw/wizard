package edu.hunau.dao;

import edu.hunau.model.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AnswerDao {

    void addAnswer(Answer answer);
}
