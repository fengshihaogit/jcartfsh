package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.dao.ProductOperationMapper;
import com.fsh.jcartstoreback.po.ProductOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Mr.Blake
 * @create 2020-03-24 22:51
 */
@Service
public class ProductOpreationServiceimpl implements ProductOpreationService{

    @Autowired
    private ProductOperationMapper productOperationMapper;

    @Override
    public void count(Integer productId) {
        ProductOperation productOperation = productOperationMapper.selectByPrimaryKey(productId);
        if(productOperation == null){
            productOperation = new ProductOperation();
            productOperation.setProductId(productId);
            productOperation.setAllCount(1);
            productOperation.setDayCount(1);
            productOperation.setRecentTime(new Date());

            productOperationMapper.insertSelective(productOperation);
        }else {
            productOperation.setDayCount(productOperation.getDayCount()+1);
            productOperation.setAllCount(productOperation.getAllCount()+1);
            productOperation.setRecentTime(new Date());
            productOperationMapper.updateByPrimaryKeySelective(productOperation);
        }
    }
}
