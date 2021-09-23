package com.qyfou.bazaar.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "bid")
public class Bid implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "goods_id")
    private Long goodsId;

    private BigDecimal price;

    private Long time;

    @Column(name = "deleted_status")
    private Short deletedStatus;
}
