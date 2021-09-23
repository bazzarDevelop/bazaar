package com.qyfou.bazaar.service;

import com.qyfou.bazaar.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getSellerOrdersList(Long userId, Integer type, Integer status, int current, int count);

    Integer getSellerOrdersNum(Long userId, Integer type, Integer status);

    List<Order> getBuyerOrdersList(Long userId, Integer type, Integer status, int current, int count);

    Integer getBuyerOrdersNum(Long userId, Integer type, Integer status);
}
