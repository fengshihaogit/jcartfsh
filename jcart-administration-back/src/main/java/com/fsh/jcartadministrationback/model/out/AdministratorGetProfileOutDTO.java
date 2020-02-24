package com.fsh.jcartadministrationback.model.out;

/**
 * @author Mr.Blake
 * @create 2020-02-24 21:35
 */
public class AdministratorGetProfileOutDTO {
    private Integer administratorId;
    private String username;
    private String realName;
    private String email;
    private String avatarUrl;
    private Byte status;
    private Long creatTimestamp;

    public AdministratorGetProfileOutDTO() {
    }


    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
