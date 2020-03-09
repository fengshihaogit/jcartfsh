package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.po.Address;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-09 20:11
 */
public interface AddressService {

    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);
}
