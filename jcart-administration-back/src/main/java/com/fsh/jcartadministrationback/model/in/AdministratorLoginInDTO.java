package com.fsh.jcartadministrationback.model.in;

/**
 * @author Mr.Blake
 * @create 2020-02-24 21:31
 */
public class AdministratorLoginInDTO {
    private String username;
    private String password;

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

    public AdministratorLoginInDTO() {
    }
}
