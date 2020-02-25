package com.fsh.jcartadministrationback.dto.in;

/**
 * @author Mr.Blake
 * @create 2020-02-25 20:30
 */
public class AdministratorResetPwdInDTO {
    private String email;
    private String resetCode;
    private String newPwd;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
