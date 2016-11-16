package com.padeoe.pojo;

public class User {
    private Integer id;

    private String userName;

    private String password;

    private String authority;

    private Integer age;

    private Risk[] risklist;

    public User(String userName, String password, String authority) {
        this.userName = userName;
        this.password = password;
        this.authority = authority;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Risk[] getRisklist() {
        return risklist;
    }

    public void setRisklist(Risk[] risklist) {
        this.risklist = risklist;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}