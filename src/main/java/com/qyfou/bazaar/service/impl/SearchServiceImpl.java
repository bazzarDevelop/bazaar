package com.qyfou.bazaar.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qyfou.bazaar.dao.GoodsDao;
import com.qyfou.bazaar.dao.SearchDao;
import com.qyfou.bazaar.model.Goods;
import com.qyfou.bazaar.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchDao searchDao;

    public List<String> JsonToList(String words) {
        List<String> searchList = new ArrayList<>();
        JSONArray jsonArray = JSON.parseArray(words);
        for (int i = 0; i < jsonArray.size(); i++) {
            String s = jsonArray.getString(i);
            searchList.add(s);
        }
        return searchList;
    }


    public List<Goods> getGoodsByCategory(Integer type, List<String> words, int current, int count) {
        for(String s:words){
            System.out.println(s);
        }
        return searchDao.selectByCategory(type, words, current, count);
    }

    public Integer getCategoryNum(Integer type, List<String> words) {
        return searchDao.getCategoryNum(type, words);
    }

    public List<Goods> getGoodsByDiscoverTags(Integer type, List<String> words, int current, int count) {
        return searchDao.selectByDiscoverTags(type, words, current, count);
    }

    public Integer getDiscoverTagsNum(Integer type,List<String> words) {
        return searchDao.getDiscoverTagsNum(type, words);
    }

    public List<Goods> getGoodsByDiscoverKeys(Integer type, String key, int current, int count) {
        return searchDao.selectByDiscoverKey(type,key,current,count);
    }

    @Override
    public Integer getDiscoverKeyNum(Integer type, String words) {
        return searchDao.getDiscoverKeyNum(type, words);
    }

    @Override
    public List<String> getTagsByHeat(){
        return searchDao.selectByHeat();
    }

    @Override
    public List<String> getTagsByHistory(Long userId) {
        List<String> res=new ArrayList<>();
        int current=0;
        while(res.size()<6) {
            List<String> list = JsonToList(searchDao.selectByHistory(userId, current));
            for(int i=list.size()-1;i>=0;i--){
                res.add(list.get(i));
                if(res.size()==6)
                    break;
            }
            current++;
        }
        return res;
    }

    @Override
    public void updateHistoryTags(Long userId,List<String> tagsList) {
        int num=searchDao.getHistoryNum(userId);
        if(num>=6){
            searchDao.deleteHistory(userId);
        }
        StringBuffer ss=new StringBuffer();
        ss.append("[");
        for(String s:tagsList){
            ss.append(s).append(",");
        }
        ss.deleteCharAt(ss.length()-1);
        ss.append("]");
        searchDao.insertHistory(userId,ss.toString());
    }
}
