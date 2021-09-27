package com.qyfou.bazaar.service;

import com.qyfou.bazaar.model.Goods;

import java.util.List;

public interface SearchService {
    List<Goods> getGoodsByCategory(Integer type, List<String> words, int current, int count);

    Integer getCategoryNum(Integer type, List<String> words);

    List<Goods> getGoodsByDiscoverTags(Integer type, List<String> words, int current, int count);

    Integer getDiscoverTagsNum(Integer type, List<String> words);

    List<Goods> getGoodsByDiscoverKeys(Integer type, String key, int current, int count);

    Integer getDiscoverKeyNum(Integer type, String key);

    List<String> getTagsByHeat();

    List<String> getTagsByHistory(Long userId);

    void updateHistoryTags(Long userId,List<String> tagsList);
}
