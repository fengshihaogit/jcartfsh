package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.po.Return;
import com.github.pagehelper.Page;

/**
 * @author Mr.Blake
 * @create 2020-03-10 21:19
 */
public interface ReturnService {

    Page<Return> search(Integer pageNum);

    Return getById(Integer returnId);
}
