package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.AddressMapper;
import com.fsh.jcartadministrationback.po.Address;
import com.fsh.jcartadministrationback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-09 20:12
 */
@Service
public class AddressServiceimpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address getById(Integer addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        return address;
    }

    @Override
    public List<Address> getByCustomerId(Integer customerId) {

        List<Address> addresses = addressMapper.selectByCustomerId(customerId);
        return addresses;
    }
}
