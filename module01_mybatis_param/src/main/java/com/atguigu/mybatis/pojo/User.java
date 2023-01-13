package com.atguigu.mybatis.pojo;

/**
 * ClassName: User
 * Package: com.atguigu.mybatis.pojo
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/10 - 22:09  22:09
 * @Version: v1.0
 */


public class User {

    private int id;
    private String username;
    private String password;
    private String gender;

    public User() {
    }

    public User(Integer id, String username, String password, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public User(int id, String username, String password, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
