package com.qyfou.bazaar.service.impl;

import com.qyfou.bazaar.dao.BidDao;
import com.qyfou.bazaar.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl {
    @Autowired
    private BidDao bidDao;

    public List<Bid> getBidList(Long goodsId, int current, int count) {
        return bidDao.selectByGoodsId(goodsId, current, count);
    }

    public Object deleteOrder(Long id) {
        bidDao.updateDeleteStatus(id);
        return "OK";
    }

}
