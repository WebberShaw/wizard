package edu.hunau.model;

import java.time.LocalDateTime;

public class Question {
    private int  id;
    private int user_id;
    private String title;
    private String content;
    private LocalDateTime  creat_time;
    private  int read_num;
    private int answer_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public LocalDateTime getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(LocalDateTime creat_time) {
        this.creat_time = creat_time;
    }

    public int getRead_num() {
        return read_num;
    }

    public void setRead_num(int read_num) {
        this.read_num = read_num;
    }

    public int getAnswer_num() {
        return answer_num;
    }

    public void setAnswer_num(int answer_num) {
        this.answer_num = answer_num;
    }

    public Question(int id, int user_id, String title, String content, LocalDateTime creat_time, int read_num, int answer_num) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.creat_time = creat_time;
        this.read_num = read_num;
        this.answer_num = answer_num;
    }

    public Question() {
    }
}
