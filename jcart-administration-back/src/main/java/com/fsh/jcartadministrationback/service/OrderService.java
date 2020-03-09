package com.fsh.jcartadministrationback.service;

import com.fsh.jcartadministrationback.dto.out.OrderListOutDTO;
import com.github.pagehelper.Page;

/**
 * @author Mr.Blake
 * @create 2020-03-09 15:18
 */
public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);
}
