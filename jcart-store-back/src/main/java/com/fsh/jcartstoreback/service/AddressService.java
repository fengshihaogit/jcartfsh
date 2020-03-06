package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.po.Address;

import java.net.Inet4Address;
import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-03 19:03
 */
public interface AddressService {

    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);

    Integer create(Address address);

    void update (Address address);

    void delete(Integer addressId);


}
