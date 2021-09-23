package com.qyfou.bazaar.service;

import com.qyfou.bazaar.model.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface GoodsService {

    String getGoodsPicUrl(Long goodsId);

    List<Goods> getGoodsList(Long userId, Integer type, int current, int count);

    List<Goods> getCollectionList(Long userId, Integer type, int current, int count);

    Integer getGoodsTotalNum(Integer type);

    Integer getGoodsNum(Long userId, Integer type);

    Integer getCollectionNum(Long userId, Integer type);

    List<Goods> getGoodsRandom(Integer type, int current, int count);

    List<Goods> getGoodByPrice(Integer type, Integer way, int current, int count);

    List<Goods> getGoodsByHeat(Integer type, int current, int count);

    List<Goods> getGoodsByTime(Integer type, int current, int count);

    Object updateHistory(Long userId, Long goodsId);
}
