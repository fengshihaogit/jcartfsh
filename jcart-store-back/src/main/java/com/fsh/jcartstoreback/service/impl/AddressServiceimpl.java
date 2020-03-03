package com.fsh.jcartstoreback.service.impl;

import com.fsh.jcartstoreback.dao.AddressMapper;
import com.fsh.jcartstoreback.po.Address;
import com.fsh.jcartstoreback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-03 19:03
 */
@Service
public class AddressServiceimpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public List<Address> getByCustomerId(Integer customerId) {
        List<Address> address = addressMapper.selectByCustomerId(customerId);
        return address;
    }

    @Override
    public Integer create(Address address) {
        int insertSelective = addressMapper.insertSelective(address);
        return insertSelective;
    }

    @Override
    public void update(Address address) {
       addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public void delete(Integer addressId) {
            addressMapper.deleteByPrimaryKey(addressId);
    }
}
