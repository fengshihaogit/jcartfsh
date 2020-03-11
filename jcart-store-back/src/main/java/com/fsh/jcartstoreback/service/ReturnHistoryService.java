package com.fsh.jcartstoreback.service;

import com.fsh.jcartstoreback.po.ReturnHistory;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-11 14:49
 */
public interface ReturnHistoryService {

    List<ReturnHistory> getByReturnId(Integer returnId);
}
