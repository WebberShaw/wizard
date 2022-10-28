package edu.hunau.model;

import java.time.LocalDateTime;

public class Comment {
    private  int id ;
    private String content;
    private LocalDateTime creat_time;
    private int prise_num;
    private int author_id;
    private  int problem_id;

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

    public LocalDateTime getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(LocalDateTime creat_time) {
        this.creat_time = creat_time;
    }

    public int getPrise_num() {
        return prise_num;
    }

    public void setPrise_num(int prise_num) {
        this.prise_num = prise_num;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }

    public Comment(int id, String content, LocalDateTime creat_time, int prise_num, int author_id, int problem_id) {
        this.id = id;
        this.content = content;
        this.creat_time = creat_time;
        this.prise_num = prise_num;
        this.author_id = author_id;
        this.problem_id = problem_id;
    }

    public Comment() {
    }
}
