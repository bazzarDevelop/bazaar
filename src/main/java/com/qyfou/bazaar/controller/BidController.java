package com.qyfou.bazaar.controller;

import com.qyfou.bazaar.model.Bid;
import com.qyfou.bazaar.service.impl.BidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bid")
public class BidController {
    @Autowired
    private BidBase bidBase;

    @Autowired
    private BidServiceImpl bidServiceImpl;

    //根据拍卖品id获取拍卖品出价列表，出价从高到低
    @GetMapping("/get")
    public Object getBidByPage(Long id, int pageNum, int pageSize) {
        return bidServiceImpl.getBidList(id, pageNum * pageSize, pageSize);
    }

    //取消拍卖出价
    @PostMapping("/delete")
    public Object deleteOrder(Long id) {
        return bidServiceImpl.deleteOrder(id);
    }

    //增加拍卖出价
    @PostMapping("/add")
    public Object saveBid(Bid bid) {
        bidBase.save(bid);
        return "OK";
    }
}
