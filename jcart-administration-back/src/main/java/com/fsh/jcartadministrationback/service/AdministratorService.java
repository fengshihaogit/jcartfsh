package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.po.Administrator;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.Blake
 * @create 2020-03-02 23:19
 */
public interface AdministratorService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    void update (Administrator administrator);
}
