package com.fsh.jcartstoreback.service.impl;

import com.fsh.jcartstoreback.dao.ReturnMapper;
import com.fsh.jcartstoreback.po.Return;
import com.fsh.jcartstoreback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Blake
 * @create 2020-03-10 23:04
 */
@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Integer create(Return aReturn) {

        returnMapper.insertSelective(aReturn);
        Integer returnId = aReturn.getReturnId();
        return returnId;
    }
}
