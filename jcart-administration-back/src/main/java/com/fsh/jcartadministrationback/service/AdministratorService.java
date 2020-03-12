package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.po.Administrator;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-02 23:19
 */
public interface AdministratorService {

    Administrator getById(Integer administratorId);

    Administrator getByEmail(String email);

    Administrator getByUsername(String username);

    Integer create (Administrator administrator);

    void update (Administrator administrator);

    void delete(Integer administratorId);

    void  batchDelete(List<Integer> administratorIds);

    Page<Administrator> getList(Integer pageNum);

}
