package com.qyfou.bazaar.controller;

import com.qyfou.bazaar.model.*;
import org.springframework.stereotype.Repository;

/*
      这里是Article实体类公共方法，继承了泛型BaseRepository<T,V>，其中T是实体类，V是主键

     如果是其他类，比如Address就是：
     @Repository
   interface ArticleBase  extends com.framework.jpa.BaseRepository<Address,Integer> {}

 */

@Repository
interface AddressBase extends com.framework.jpa.BaseRepository<Address, Long> {
}

@Repository
interface UserBase extends com.framework.jpa.BaseRepository<User, Long> {
}

@Repository
interface StudentBase extends com.framework.jpa.BaseRepository<Student, Integer> {
}

@Repository
interface MerhchantBase extends com.framework.jpa.BaseRepository<Merchant, Integer> {
}

@Repository
interface GoodsCommentBase extends com.framework.jpa.BaseRepository<GoodsComment, Long> {
}

@Repository
interface BidBase extends com.framework.jpa.BaseRepository<Bid, Long> {
}

@Repository
interface GoodsBase extends com.framework.jpa.BaseRepository<Goods,Long>{
}


public class BaseController {

}