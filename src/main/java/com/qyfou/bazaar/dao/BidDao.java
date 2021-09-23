package com.qyfou.bazaar.dao;

import com.qyfou.bazaar.model.Bid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BidDao {
    List<Bid> selectByGoodsId(
            @Param("goodsId") Long goodsId, @Param("current") int current, @Param("count") int count);

    Integer updateDeleteStatus(@Param("id") Long id);
}
