package com.Jaziel.POJO;

import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户
 */

public class User{

    @NonNull
    @Size(max = 2, min = 1, message = "${gender.size}")
    private String gender = ""; // 性别

    @NonNull
    @Size(max = 4, min = 2, message = "${username.size}")
    private String username = ""; // 用户名，唯一

    @NonNull
    @Size(max = 11, min = 6, message = "{password.size}")
    private String password = ""; // 密码

    @NonNull
    @Size(max = 11, min = 11, message = "{telephone.size}")
    private String telephone = ""; // 联系电话

    public User(@NonNull @Size(max = 2, min = 1, message = "{gender.size}") String gender, @NonNull @Size(max = 4, min = 2, message = "{username.size}") String username, @NonNull @Size(max = 11, min = 6, message = "{password.size}") String password, @NonNull @Size(max = 11, min = 11, message = "{telephone.size}") String telephone) {
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
    }

    public User() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
