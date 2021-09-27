package com.qyfou.bazaar.dao;

import com.qyfou.bazaar.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchDao {
    //商品分类
    List<Goods> selectByCategory(@Param("type") Integer type, @Param("words") List<String> words,
                                 @Param("current") int current, @Param("count") int count);

    int getCategoryNum(@Param("type") Integer type, @Param("words") List<String> words);

    //商品搜索
    List<Goods> selectByDiscoverTags(@Param("type") Integer type, @Param("words") List<String> words,
                                     @Param("current") int current, @Param("count") int count);

    int getDiscoverTagsNum(@Param("type") Integer type, @Param("words") List<String> words);

    List<Goods> selectByDiscoverKey(@Param("type") Integer type, @Param("key") String key,
                                    @Param("current") int current, @Param("count") int count);

    int getDiscoverKeyNum(@Param("type") Integer type, @Param("key") String key);

    List<String> selectByHeat();

    String selectByHistory(@Param("userId") Long userId,@Param("current") int current);

    int getHistoryNum(@Param("userId") Long userId);

    void deleteHistory(@Param("userId") Long userId);

    void insertHistory(@Param("userId") Long userId,@Param("tags") String tags);
}
