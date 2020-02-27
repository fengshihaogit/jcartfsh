package com.fsh.jcartadministrationback.dao;

import com.fsh.jcartadministrationback.po.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}