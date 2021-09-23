package com.qyfou.bazaar.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface GoodsCommentDao {
    List<Map<String, Object>> getComment(@Param("type") Integer type, @Param("typeId") Long typeId,
                                         @Param("current") int current, @Param("count") int count);

    Integer getCommentNum(@Param("type") Integer type, @Param("typeId") Long typeId);
}