package com.fsh.jcartadministrationback.service.impl;

import com.fsh.jcartadministrationback.dao.AdministratorMapper;
import com.fsh.jcartadministrationback.po.Administrator;
import com.fsh.jcartadministrationback.service.AdministratorService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-02 23:19
 */
@Service
public class AdministratorServiceimpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;


    @Override
    public Administrator getById(Integer administratorId) {
        Administrator administrator = administratorMapper.selectByPrimaryKey(administratorId);
        return administrator;
    }

    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.selectByUsername(username);
        return administrator;
    }

    @Override
    public Integer create(Administrator administrator) {
        int insertSelective = administratorMapper.insertSelective(administrator);
        return insertSelective;
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public void delete(Integer administratorId) {
        administratorMapper.deleteByPrimaryKey(administratorId);
    }

    @Override
    public void batchDelete(List<Integer> administratorIds) {
            administratorMapper.batchDelete(administratorIds);
    }

    @Override
    public Page<Administrator> getList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Administrator> administrators = administratorMapper.selectList();
        return administrators;
    }
}
