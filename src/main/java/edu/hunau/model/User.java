package edu.hunau.model;

import java.time.LocalDateTime;

public class User {
    private int id;
    private  String  username;
    private String  school;
    private String tel;
    private String password;
    private  String email;
    private LocalDateTime creat_time;
    private LocalDateTime update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(LocalDateTime creat_time) {
        this.creat_time = creat_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public User() {
    }
}
