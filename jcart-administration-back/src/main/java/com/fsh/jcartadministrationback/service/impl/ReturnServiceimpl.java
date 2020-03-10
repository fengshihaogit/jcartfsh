package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.ReturnMapper;
import com.fsh.jcartadministrationback.po.Return;
import com.fsh.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Blake
 * @create 2020-03-10 21:22
 */
@Service
public class ReturnServiceimpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;


    @Override
    public Integer create(Return aReturn) {
        returnMapper.insertSelective(aReturn);
        Integer returnId = aReturn.getReturnId();
        return returnId;
    }
}
