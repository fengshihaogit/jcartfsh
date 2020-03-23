package com.fsh.jcartsupportback.mq;

/**
 * @author Mr.Blake
 * @create 2020-03-23 20:42
 */
public class EmailEvent {
    private String toEmail;
    private String title;
    private String content;

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
