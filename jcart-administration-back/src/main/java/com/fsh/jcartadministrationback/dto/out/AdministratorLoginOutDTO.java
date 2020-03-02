package com.fsh.jcartadministrationback.dto.out;

/**
 * @author Mr.Blake
 * @create 2020-03-02 23:22
 */
public class AdministratorLoginOutDTO {

    private String token;
    private Long expireTimestamp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpireTimestamp() {
        return expireTimestamp;
    }

    public void setExpireTimestamp(Long expireTimestamp) {
        this.expireTimestamp = expireTimestamp;
    }
}
