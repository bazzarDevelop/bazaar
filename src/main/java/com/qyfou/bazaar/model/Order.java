package com.qyfou.bazaar.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sellerId;

    private Long buyerId;

    private Long goodsId;

    private Short status;

    private int num;

    private BigDecimal totalPrice;

    private Long time;

    private Short goodsType;

    private String waybill;

    private String name;

    private String introImage;
}
