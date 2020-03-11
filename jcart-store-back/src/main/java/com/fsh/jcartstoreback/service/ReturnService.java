package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.po.Return;
import com.github.pagehelper.Page;

/**
 * @author Mr.Blake
 * @create 2020-03-10 23:03
 */
public interface ReturnService {

    Integer create (Return aReturn);

    Page<Return> getPageByCustomerId(Integer customerId,Integer pageNum);
}
