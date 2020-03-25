package com.fsh.jcartsupportback.mq;

import java.io.Serializable;

/**
 * @author Mr.Blake
 * @create 2020-03-25 17:59
 */
public class HotProductDTO implements Serializable {

    private Integer productId;
    private String productCode;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
