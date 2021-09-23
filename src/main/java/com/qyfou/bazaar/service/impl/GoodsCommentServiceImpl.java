package com.qyfou.bazaar.service.impl;

import com.qyfou.bazaar.dao.GoodsCommentDao;
import com.qyfou.bazaar.service.GoodsComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsCommentServiceImpl implements GoodsComment {

    @Autowired
    GoodsCommentDao goodsCommentDao;

    @Override
    public List<Map<String, Object>> getComment(Integer type, Long typeId, int current, int count) {
        return goodsCommentDao.getComment(type, typeId, current, count);
    }

    @Override
    public Integer getCommentNum(Integer type, Long typeId) {
        return goodsCommentDao.getCommentNum(type, typeId);
    }
}
