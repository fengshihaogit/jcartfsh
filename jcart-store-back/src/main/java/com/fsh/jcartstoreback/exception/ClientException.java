package com.fsh.jcartstoreback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;

/**
 * @author Mr.Blake
 * @create 2020-03-01 17:13
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientException extends ServletException {

    private String errCode;

    public ClientException(String message, String errCode) {
        super(message);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
