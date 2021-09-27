package com.qyfou.bazaar.service.impl;

import com.qyfou.bazaar.dao.GoodsDao;
import com.qyfou.bazaar.model.Goods;
import com.qyfou.bazaar.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

//    @Override
//    public String getGoodsPicUrl(Long goodsId) {
//        return goodsDao.getGoodsPicUrl(goodsId);
//    }

    public List<Goods> getGoodsList(Long userId, Integer type, int current, int count) {
        if (type == null) type = -1;
        return goodsDao.selectGoodsByUserId(userId, type, current, count);
    }

    public List<Goods> getCollectionList(Long userId, Integer type, int current, int count) {
        if (type == null) type = -1;
        return goodsDao.selectCollectionByUserId(userId, type, current, count);
    }


    public Integer getGoodsNum(Long userId, Integer type) {
        if (userId == null) userId = -1L;
        if (type == null) type = -1;
        return goodsDao.getGoodsNum(userId, type);
    }

    public Integer getCollectionNum(Long userId, Integer type) {
        if (type == null) type = -1;
        return goodsDao.getCollectionNum(userId, type);
    }

    public List<Goods> getGoodsRandom(Integer type, int current, int count) {
        List<Goods> res = goodsDao.selectRandom(type, current, count);
        return res;
    }

    public List<Goods> getGoodByPrice(Integer type, Integer way, int current, int count) {
        if (way == 0) {
            return goodsDao.selectByPriceAsc(type, current, count);
        } else {
            return goodsDao.selectByPriceDesc(type, current, count);
        }
    }

    public List<Goods> getGoodsByHeat(Integer type, int current, int count) {
        return goodsDao.selectByHeat(type, current, count);
    }

    public List<Goods> getGoodsByTime(Integer type, int current, int count) {
        return goodsDao.selectByTime(type, current, count);
    }

    public List<Goods> getGoodsByHistory(Long userId) {
        return goodsDao.selectByHistory(userId);
    }


    @Override
    public Integer getGoodsTotalNum(Integer type) {
        if (type == null) type = -1;
        return goodsDao.getGoodsTotal(type);
    }

    @Override
    public Object updateHistory(Long userId, Long goodsId) {
        int now = goodsDao.getHistoryNum(userId);
        if (now >= 30) {
            goodsDao.deleteHistory(userId);
        }
        goodsDao.insertHistory(userId, goodsId);
        return "OK";
    }
}
