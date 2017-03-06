package com.wenyuan.seckill.entity;

/**
 * 用户数据的domain类
 * @author ScienJus
 * @date 2015/7/31.
 */
public class User {
    //用户名
    private String username;

    //密码
    private String password;

    //用户id
    private long id;

    //昵称
    private String nickname;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
