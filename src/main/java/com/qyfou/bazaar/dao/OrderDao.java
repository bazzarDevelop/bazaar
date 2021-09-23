package com.qyfou.bazaar.dao;

import com.qyfou.bazaar.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderDao {
    List<Order> selectSellerOrdersByUserId(@Param("userId") Long userId, @Param("type") Integer type, @Param("status") Integer status,
                                           @Param("current") int current, @Param("count") int count);

    Integer getSellerOrdersNum(@Param("userId") Long userId, @Param("type") Integer type, @Param("status") Integer status);

    List<Order> selectBuyerOrdersByUserId(@Param("userId") Long userId, @Param("type") Integer type, @Param("status") Integer status,
                                          @Param("current") int current, @Param("count") int count);

    Integer getBuyerOrdersNum(@Param("userId") Long userId, @Param("type") Integer type, @Param("status") Integer status);
}

