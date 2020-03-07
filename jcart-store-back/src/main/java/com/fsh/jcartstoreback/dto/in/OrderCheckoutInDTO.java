package com.fsh.jcartstoreback.dto.in;

import java.util.List;

public class OrderCheckoutInDTO {
    private Short shipMethod;
    private Integer shipAddressId;
    private Short payMethod;
    private Integer invoiceAddressId;
    private String comment;
    private List<OrderProductInDTO> orderProducts;

    public Short getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(Short shipMethod) {
        this.shipMethod = shipMethod;
    }

    public Integer getShipAddressId() {
        return shipAddressId;
    }

    public void setShipAddressId(Integer shipAddressId) {
        this.shipAddressId = shipAddressId;
    }

    public Short getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Short payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getInvoiceAddressId() {
        return invoiceAddressId;
    }

    public void setInvoiceAddressId(Integer invoiceAddressId) {
        this.invoiceAddressId = invoiceAddressId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<OrderProductInDTO> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductInDTO> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
