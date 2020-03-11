package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.ReturnHistoryMapper;
import com.fsh.jcartadministrationback.po.Return;
import com.fsh.jcartadministrationback.po.ReturnHistory;
import com.fsh.jcartadministrationback.service.ReturnHistoryService;
import com.fsh.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-11 21:16
 */
@Service
public class ReturnHistoryServiceimpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Autowired
    private ReturnService returnService;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectByReturnId(returnId);
        return returnHistories;
    }

    @Override
    public Long create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return aReturn = new Return();
        aReturn.setReturnId(returnHistory.getReturnId());
        aReturn.setUpdateTime(new Date());
        returnService.update(aReturn);
        return returnHistoryId;
    }


}
