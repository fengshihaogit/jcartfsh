package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.po.ReturnHistory;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-11 21:14
 */
public interface ReturnHistoryService {

    List<ReturnHistory> getListByReturnId(Integer returnId);

    Long create (ReturnHistory returnHistory);
}
