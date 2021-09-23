package com.qyfou.bazaar.service;

import com.qyfou.bazaar.model.Bid;

import java.util.List;

public interface BidService {
    public List<Bid> getBidList(Long goodsId, int current, int count);

    public Integer deleteOrder(Long id);
}
