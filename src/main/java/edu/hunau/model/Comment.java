package edu.hunau.model;

import java.time.LocalDateTime;

public class Comment {
    private  Integer id ;
    private String content;
    private LocalDateTime creatTime;
    private Integer likes;
    private int userId;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creatTime=" + creatTime +
                ", likes=" + likes +
                ", userId=" + userId +
                ", answerId=" + answerId +
                '}';
    }

    private  int answerId;

    public Comment(int id, String content, LocalDateTime creatTime, int likes, int userId, int answerId) {
        this.id = id;
        this.content = content;
        this.creatTime = creatTime;
        this.likes = likes;
        this.userId = userId;
        this.answerId = answerId;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
