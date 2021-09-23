package com.qyfou.bazaar.controller;

import com.qyfou.bazaar.model.GoodsComment;
import com.qyfou.bazaar.service.impl.GoodsCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodsComment")
public class GoodsCommentController {

    @Autowired
    private GoodsCommentServiceImpl goodsCommentServiceImpl;

    @Autowired
    private GoodsCommentBase goodsCommentBase;

    //根据商品id获取商品评论
    @GetMapping("/get")
    public Object getCommentByPage(Integer type, Long typeId,
                                   int pageNum, int pageSize) {
        return goodsCommentServiceImpl.getComment(type, typeId, pageNum * pageSize, pageSize);
    }

    //新增商品评论
    @PostMapping("/add")
    public Object saveComment(GoodsComment comment) {
        goodsCommentBase.save(comment);
        return "OK";
    }

    //根绝商品id获取评论数量
    @GetMapping("/getnum")
    public Object getPages(Integer type, Long typeId) {
        return goodsCommentServiceImpl.getCommentNum(type, typeId);
    }
}
