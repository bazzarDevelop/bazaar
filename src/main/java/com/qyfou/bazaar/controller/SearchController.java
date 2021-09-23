package com.qyfou.bazaar.controller;

import com.qyfou.bazaar.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchServiceImpl searchServiceImpl;

    //根据类别获取对应符合条件的商品、拍卖品
    @GetMapping("/category")
    public Object getGoodsByClass(Integer type, String words, int pageNum, int pageSize) {
        return searchServiceImpl.getGoodsByCategory(type, words, pageNum * pageSize, pageSize);
    }

    //根据类别获取对应符合条件的商品、拍卖品数量
    @GetMapping("/category/nums")
    public Object getClassPages(Integer type, String words) {
        return searchServiceImpl.getCategoryNum(type, words);
    }

    //根据搜索条件获取对应符合条件的商品、拍卖品
    @GetMapping("/discover")
    public Object getGoodsByDiscover(Integer type, String words, int pageNum, int pageSize) {
        return searchServiceImpl.getGoodsByDiscover(type, words, pageNum * pageSize, pageSize);
    }

    //根据搜索条件获取对应符合条件的商品、拍卖品数量
    @GetMapping("/discover/nums")
    public Object getDiscoverPages(Integer type, String words) {
        return searchServiceImpl.getDiscoverNum(type, words);
    }
}
