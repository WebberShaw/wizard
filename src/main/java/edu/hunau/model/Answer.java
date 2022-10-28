package edu.hunau.model;

import java.time.LocalDateTime;

public class Answer {
private int id;
private LocalDateTime creat_time;
private String content;
private int user_id;
private int likes;
private LocalDateTime update_time;
private int questionId;

    public Answer(int id, LocalDateTime creat_time, String content, int user_id, int likes, LocalDateTime update_time, int questionId) {
        this.id = id;
        this.creat_time = creat_time;
        this.content = content;
        this.user_id = user_id;
        this.likes = likes;
        this.update_time = update_time;
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(LocalDateTime creat_time) {
        this.creat_time = creat_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }
    public Answer() {
    }
}
