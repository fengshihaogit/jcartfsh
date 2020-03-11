package com.fsh.jcartstoreback.service.impl;

import com.fsh.jcartstoreback.dao.ReturnHistoryMapper;
import com.fsh.jcartstoreback.po.ReturnHistory;
import com.fsh.jcartstoreback.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-11 14:51
 */
@Service
public class ReturnHistoryServiceimpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;


    @Override
    public List<ReturnHistory> getByReturnId(Integer returnId) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectByReturnId(returnId);
        return returnHistories;
    }
}
