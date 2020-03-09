package com.fsh.jcartadministrationback.dto.in;

/**
 * @author Mr.Blake
 * @create 2020-03-09 21:35
 */
public class CustomerSetStatusInDTO {
    private Integer customerId;
    private Byte status;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
