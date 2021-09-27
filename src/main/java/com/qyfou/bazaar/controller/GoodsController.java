package com.qyfou.bazaar.controller;
import com.qyfou.bazaar.common.utils.PicUpload;
import com.qyfou.bazaar.model.Goods;
import com.qyfou.bazaar.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsServiceImpl;

    @Autowired
    private GoodsBase goodsBase;

//    //根据商品拍卖品的id获取对应url
//    @GetMapping("/image")
//    public Object getGoodsPicUrl(Long id) {
//        return goodsServiceImpl.getGoodsPicUrl(id);
//    }

    //获取商品拍卖品总数,type指定商品类型:普通商品 拍卖品
    @GetMapping("/nums/total")
    public Object getGoodsPages(Integer type) {
        return goodsServiceImpl.getGoodsTotalNum(type);
    }


    //根据用户id获取用户所拥有作品列表,type指定作品类型:普通商品 拍卖品
    @GetMapping("/get")
    public Object getGoodsByPage(Long id, Integer type, int pageNum, int pageSize) {
        return goodsServiceImpl.getGoodsList(id, type, pageNum * pageSize, pageSize);
    }


    //根据用户id获取用户作品数量,type指定商品类型:普通商品 拍卖品
    @GetMapping("/nums/user")
    public Object getGoodsPages(Long id, Integer type) {
        return goodsServiceImpl.getGoodsNum(id, type);
    }

    //根据用户id获取用户所收藏商品列表,type指定作品类型:普通商品 拍卖品
    @GetMapping("/collect")
    public Object getCollectionByPage(Long id, Integer type, int pageNum, int pageSize) {
        return goodsServiceImpl.getCollectionList(id, type, pageNum * pageSize, pageSize);
    }


    //根据用户id获取用户收藏商品数量,type指定商品类型:普通商品 拍卖品
    @GetMapping("/nums/collect")
    public Object getCollectionPages(Long id, Integer type) {
        return goodsServiceImpl.getCollectionNum(id, type);
    }


    //随机获得一定数量的商品、拍卖品组成列表
    @GetMapping("/random")
    public Object getGoodsByPage(Integer type, int pageNum, int pageSize) {
        return goodsServiceImpl.getGoodsRandom(type, pageNum * pageSize, pageSize);
    }

    //按价格升序或降序列出商品、拍卖品
    @GetMapping("/price")
    public Object getGoodsByPage(Integer type, Integer way, int pageNum, int pageSize) {
        return goodsServiceImpl.getGoodByPrice(type, way, pageNum * pageSize, pageSize);
    }

    //按热度列出商品、拍卖品
    @GetMapping("/heat")
    public Object getGoodsByHeat(Integer type, int pageNum, int pageSize) {
        return goodsServiceImpl.getGoodsByHeat(type, pageNum * pageSize, pageSize);
    }


    //按时间列出商品、拍卖品
    @GetMapping("/time")
    public Object getGoodsByTime(Integer type, int pageNum, int pageSize) {
        return goodsServiceImpl.getGoodsByTime(type, pageNum * pageSize, pageSize);
    }

    @GetMapping("/getById")
    public Object get(Long id) {
        return goodsBase.findById(id);
    }

   //更新用户的历史浏览记录
    @PostMapping("/history/update")
    public Object updateHistory(Long userId, Long goodsId) {
        return goodsServiceImpl.updateHistory(userId, goodsId);
    }

    //获取用户历史浏览记录表
    @GetMapping("/history")
    public Object getGoodsByHistory(Long userId) {
        return goodsServiceImpl.getGoodsByHistory(userId);
    }


    //上传商品图片
    @PostMapping("/uploadImage")
    public Object uploadImage(HttpServletRequest request) throws Exception {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        PicUpload.uploadFile(files,1);
        return "OK";
    }

    //添加商品实体
    @PostMapping("/add")
    public Object addGoods(@RequestBody Goods goods){
        goodsBase.save(goods);
        return "OK";
    }
}
