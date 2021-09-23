package com.qyfou.bazaar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "goods_comment")
public class GoodsComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    private Long createDate;


    @Column(name = "user_id")
    private Long userId;

    private Integer type;

    @Column(name = "type_id")
    private Long typeId;

    private String content;
}
