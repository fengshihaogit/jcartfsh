package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.ReturnHistoryMapper;
import com.fsh.jcartadministrationback.po.ReturnHistory;
import com.fsh.jcartadministrationback.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-11 21:16
 */
@Service
public class ReturnHistoryServiceimpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectByReturnId(returnId);
        return returnHistories;
    }

    @Override
    public Long create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();
        return returnHistoryId;
    }
}
