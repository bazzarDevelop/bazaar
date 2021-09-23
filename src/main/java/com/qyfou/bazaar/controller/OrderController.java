package com.qyfou.bazaar.controller;

import com.qyfou.bazaar.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    //根据用户id获取用户所卖出的商品拍卖品
    @GetMapping("/seller")
    public Object getSellerOrdersByPage(Long id, Integer type, Integer status, int pageNum, int pageSize) {
        return orderServiceImpl.getSellerOrdersList(id, type, status, pageNum * pageSize, pageSize);
    }

    //根据用户id获取用户所卖出的商品拍卖品数量
    @GetMapping("/seller/nums")
    public Object getSellerOrdersPages(Long id, Integer type, Integer status) {
        return orderServiceImpl.getSellerOrdersNum(id, type, status);
    }

    //根据用户id获取用户所买的商品拍卖品
    @GetMapping("/buyer")
    public Object getBuyerOrdersByPage(Long id, Integer type, Integer status, int pageNum, int PageSize) {
        return orderServiceImpl.getBuyerOrdersList(id, type, status, pageNum * PageSize, PageSize);
    }

    //根据用户id获取用户所买的商品拍卖品数量
    @GetMapping("/buyer/nums")
    public Object getBuyerOrdersPages(Long id, Integer type, Integer status) {
        return orderServiceImpl.getBuyerOrdersNum(id, type, status);
    }
}
