package com.qyfou.bazaar.controller;

import com.qyfou.bazaar.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchServiceImpl searchServiceImpl;

    //根据类别获取对应符合条件的商品、拍卖品
    @GetMapping("/category")
    public Object getGoodsByClass(Integer type, @RequestParam List<String> words, int pageNum, int pageSize) {
        return searchServiceImpl.getGoodsByCategory(type, words, pageNum * pageSize, pageSize);
    }

    //根据类别获取对应符合条件的商品、拍卖品数量
    @GetMapping("/category/nums")
    public Object getClassPages(Integer type, @RequestParam List<String> words) {
        return searchServiceImpl.getCategoryNum(type, words);
    }

    //根据搜索条件(标签)获取对应符合条件的商品、拍卖品
    @GetMapping("/discover/tags")
    public Object getGoodsByDiscoverTags(Integer type,@RequestParam List<String> words, int pageNum, int pageSize) {
        return searchServiceImpl.getGoodsByDiscoverTags(type, words, pageNum * pageSize, pageSize);
    }

    //根据搜索条件(标签)获取对应符合条件的商品、拍卖品数量
    @GetMapping("/discover/tags/nums")
    public Object getDiscoverTagsPages(Integer type, @RequestParam List<String> words) {
        return searchServiceImpl.getDiscoverTagsNum(type, words);
    }

    //根据搜索条件(关键字)获取符合条件的商品、拍卖品
    @GetMapping("/discover/key")
    public Object getGoodsByDiscoverKey(Integer type, String key, int pageNum, int pageSize) {
        return searchServiceImpl.getGoodsByDiscoverKeys(type, key, pageNum * pageSize, pageSize);
    }

    //根据搜索条件(关键字)获取对应符合条件的商品、拍卖品数量
    @GetMapping("/discover/key/nums")
    public Object getDiscoverKeyPages(Integer type, String words) {
        return searchServiceImpl.getDiscoverKeyNum(type, words);
    }

    //获取热门标签列表
    @GetMapping("/tags/heat")
    public Object getTagsByHeat() {
        return searchServiceImpl.getTagsByHeat();
    }

     //获取用户历史标签列表
    @GetMapping("/tags/history")
    public Object getTagsByHistory(Long userId) {
        return searchServiceImpl.getTagsByHistory(userId);
    }

    //更新用户历史标签列表
    @PostMapping("/tags/history/update")
    public Object updateTagsHistory(Long userId,@RequestParam List<String> tagsList) {
        searchServiceImpl.updateHistoryTags(userId,tagsList);
        return "OK";
    }
}
