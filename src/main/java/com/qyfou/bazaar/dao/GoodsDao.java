package com.qyfou.bazaar.dao;

import com.qyfou.bazaar.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface GoodsDao {

    String getGoodsPicUrl(@Param("goodsId") Long goodsId);

    List<Goods> selectGoodsByUserId(@Param("userId") Long userId, @Param("type") Integer type, @Param("current") int current, @Param("count") int count);

    List<Goods> selectCollectionByUserId(@Param("userId") Long userId, @Param("type") Integer type, @Param("current") int current, @Param("count") int count);

    Integer getGoodsTotal(@Param("type") Integer type);

    Integer getGoodsNum(@Param("userId") Long userId, @Param("type") Integer type);

    Integer getCollectionNum(@Param("userId") Long userId, @Param("type") Integer type);

    List<Goods> selectRandom(@Param("type") Integer type, @Param("current") int current, @Param("count") int count);

    List<Goods> selectByPriceDesc(@Param("type") Integer type, @Param("current") int current, @Param("count") int count);

    List<Goods> selectByPriceAsc(@Param("type") Integer type, @Param("current") int current, @Param("count") int count);

    List<Goods> selectByHeat(@Param("type") Integer type, @Param("current") int current, @Param("count") int count);

    List<Goods> selectByTime(@Param("type") Integer type, @Param("current") int current, @Param("count") int count);

    List<Goods> selectByCategory(@Param("type") Integer type, @Param("words") List<String> words,
                                 @Param("current") int current, @Param("count") int count);

    int getCategoryNum(@Param("type") Integer type, @Param("words") List<String> words);

    List<Goods> selectByDiscover(@Param("type") Integer type, @Param("words") List<String> words,
                                 @Param("current") int current, @Param("count") int count);

    int getDiscoverNum(@Param("type") Integer type, @Param("words") List<String> words);

    void insertHistory(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

    int getHistoryNum(@Param("userId") Long userId);

    void deleteHistory(@Param("userId") Long userId);

    List<Goods> selectByHistory(@Param("userId") Long userId);

}
