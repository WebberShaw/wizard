package edu.hunau.model;

import java.time.LocalDateTime;

public class Answer {
    private String richtextContent;

    @Override
    public String toString() {
        return "Answer{" +
                "richtextContent='" + richtextContent + '\'' +
                ", id=" + id +
                ", creatTime=" + creatTime +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", likes=" + likes +
                ", updateTime=" + updateTime +
                ", questionId=" + questionId +
                ", username='" + username + '\'' +
                '}';
    }

    public String getRichtextContent() {
        return richtextContent;
    }

    public void setRichtextContent(String richtextContent) {
        this.richtextContent = richtextContent;
    }

    private int id;
private LocalDateTime creatTime;
private String content;
private int userId;
private int likes;
private LocalDateTime updateTime;
private int questionId;

private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Answer() {
    }

    public Answer(int id, LocalDateTime creatTime, String content, int userId, int likes, LocalDateTime updateTime, int questionId) {
        this.id = id;
        this.creatTime = creatTime;
        this.content = content;
        this.userId = userId;
        this.likes = likes;
        this.updateTime = updateTime;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
