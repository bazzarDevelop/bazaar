package com.qyfou.bazaar.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qyfou.bazaar.dao.GoodsDao;
import com.qyfou.bazaar.model.Goods;
import com.qyfou.bazaar.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private GoodsDao goodsDao;

    public List<String> JsonToList(String words) {
        List<String> searchList = new ArrayList<>();
        JSONArray jsonArray = JSON.parseArray(words);
        for (int i = 0; i < jsonArray.size(); i++) {
            String s = jsonArray.getString(i);
            searchList.add(s);
        }
        return searchList;
    }


    public List<Goods> getGoodsByCategory(Integer type, String words, int current, int count) {
        return goodsDao.selectByCategory(type, JsonToList(words), current, count);
    }

    public Integer getCategoryNum(Integer type, String words) {
        return goodsDao.getCategoryNum(type, JsonToList(words));
    }

    public List<Goods> getGoodsByDiscover(Integer type, String words, int current, int count) {

        return goodsDao.selectByDiscover(type, JsonToList(words), current, count);
    }

    public Integer getDiscoverNum(Integer type, String words) {
        return goodsDao.getDiscoverNum(type, JsonToList(words));
    }
}
