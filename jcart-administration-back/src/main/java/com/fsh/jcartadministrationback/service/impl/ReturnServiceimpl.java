package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.ReturnMapper;
import com.fsh.jcartadministrationback.dto.in.ReturnSearchInDTO;
import com.fsh.jcartadministrationback.po.Return;
import com.fsh.jcartadministrationback.service.ReturnService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Mr.Blake
 * @create 2020-03-10 21:22
 */
@Service
public class ReturnServiceimpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Page<Return> search(ReturnSearchInDTO returnSearchInDTO,Integer pageNum) {

        PageHelper.startPage(pageNum,10);
        Page<Return> search = returnMapper.search(
                returnSearchInDTO.getReturnId(),
                returnSearchInDTO.getOrderId(),
                returnSearchInDTO.getStartTimestamp() == null ? null : new Date(returnSearchInDTO.getStartTimestamp()),
                returnSearchInDTO.getEndTimestemp() == null ? null : new Date(returnSearchInDTO.getEndTimestemp()),
                returnSearchInDTO.getStatus(),
                returnSearchInDTO.getProductCode(),
                returnSearchInDTO.getCustomerName(),
                returnSearchInDTO.getProductName());
        return search;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }

    @Override
    public void update(Return aReturn) {
        returnMapper.updateByPrimaryKeySelective(aReturn);
    }
}
