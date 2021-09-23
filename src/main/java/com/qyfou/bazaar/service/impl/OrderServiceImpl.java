package com.qyfou.bazaar.service.impl;

import com.qyfou.bazaar.dao.OrderDao;
import com.qyfou.bazaar.model.Order;
import com.qyfou.bazaar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public List<Order> getSellerOrdersList(Long userId, Integer type, Integer status, int current, int count) {
        if (status == null) status = -1;
        return orderDao.selectSellerOrdersByUserId(userId, type, status, current, count);
    }

    public Integer getSellerOrdersNum(Long userId, Integer type, Integer status) {
        if (status == null) status = -1;
        return orderDao.getSellerOrdersNum(userId, type, status);
    }

    public List<Order> getBuyerOrdersList(Long userId, Integer type, Integer status, int current, int count) {
        if (status == null) status = -1;
        return orderDao.selectBuyerOrdersByUserId(userId, type, status, current, count);
    }

    public Integer getBuyerOrdersNum(Long userId, Integer type, Integer status) {
        if (status == null) status = -1;
        return orderDao.getBuyerOrdersNum(userId, type, status);
    }
}
