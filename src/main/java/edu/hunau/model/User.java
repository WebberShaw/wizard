package edu.hunau.model;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;
@Validated//开启注入校验
public class User {
    private int id;
    private  String  username;
    private String  school;
    private String tel;

    private String password;
    @Email
    private  String email;
    private String company;

    private int verifyCode;

    private String avatarPath;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", school='" + school + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", verifyCode=" + verifyCode +
                ", avatarPath='" + avatarPath + '\'' +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    private LocalDateTime creatTime;
    private LocalDateTime updateTime;

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

    public LocalDateTime getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(LocalDateTime creatTime) {
        this.creatTime = creatTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public User() {
    }

    public User(int id, String username, String school, String tel, String password, String email, LocalDateTime creatTime, LocalDateTime updateTime) {
        this.id = id;
        this.username = username;
        this.school = school;
        this.tel = tel;
        this.password = password;
        this.email = email;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }
}
