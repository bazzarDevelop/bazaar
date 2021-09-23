package com.qyfou.bazaar.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    Long selectIdByOpenId(@Param("openId") String openId);
}
