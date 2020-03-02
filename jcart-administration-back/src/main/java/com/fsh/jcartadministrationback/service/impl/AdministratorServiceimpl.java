package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.AdministratorMapper;
import com.fsh.jcartadministrationback.po.Administrator;
import com.fsh.jcartadministrationback.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Blake
 * @create 2020-03-02 23:19
 */
@Service
public class AdministratorServiceimpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;


    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.selectByUsername(username);
        return administrator;
    }
}
