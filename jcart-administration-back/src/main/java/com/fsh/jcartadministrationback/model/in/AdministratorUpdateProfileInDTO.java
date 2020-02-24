package com.fsh.jcartadministrationback.model.in;

/**
 * @author Mr.Blake
 * @create 2020-02-24 21:46
 */
public class AdministratorUpdateProfileInDTO {
    private String realName;
    private String email;
    private String avatarUrl;
    private String password;
    private Byte status;

    public AdministratorUpdateProfileInDTO() {
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
