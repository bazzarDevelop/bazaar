package com.qyfou.bazaar.service;

import com.qyfou.bazaar.model.Goods;

import java.util.List;

public interface SearchService {
    List<Goods> getGoodsByCategory(Integer type, String words, int current, int count);

    Integer getCategoryNum(Integer type, String words);

    List<Goods> getGoodsByDiscover(Integer type, String words, int current, int count);

    Integer getDiscoverNum(Integer type, String words);
}
