package com.padeoe.pojo;

/**
 * User类定义了系统用户，属性包含用户身份信息及权限，操作包括对这些信息的获取及更改
 *
 * @author padeoe
 *         Date: 2016/11/16
 */
public class User {


    /**
     * 用户名，是唯一的，根据用户名区别用户
     * 长度在{@link com.padeoe.controller.UserController#MIN_USERNAME_LENGTH}和 {@link com.padeoe.controller.UserController#MAX_USERNAME_LENGTH}之间
     */
    private String username;
    /**
     * 用户的登录密码，长度在{@link com.padeoe.controller.UserController#MIN_PASSWORD_LENGTH}和 {@link com.padeoe.controller.UserController#MAX_PASSWORD_LENGTH}之间
     */
    private String password;

    /**
     * 用户权限
     */
    private String authority;


    /**
     * 创建新用户
     *
     * @param userName  用户名
     * @param password  密码
     * @param authority 权限
     */
    public User(String userName, String password, String authority) {
        this.username = userName;
        this.password = password;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}