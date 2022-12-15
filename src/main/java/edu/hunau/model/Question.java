package edu.hunau.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Question {
    private String richtextContent;

    public String getRichtextContent() {
        return richtextContent;
    }

    public void setRichtextContent(String richtextContent) {
        this.richtextContent = richtextContent;
    }

    private int  id;
    private int userId;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime  creatTime;
    private  int readNum;
    private int answerNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creatTime=" + creatTime +
                ", readNum=" + readNum +
                ", answerNum=" + answerNum +
                '}';
    }

    public Question(int id, int userId, String title, String content, LocalDateTime creatTime, int readNum, int answerNum) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.creatTime = creatTime;
        this.readNum = readNum;
        this.answerNum = answerNum;
    }

    public Question() {
    }
}
