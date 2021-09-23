package com.qyfou.bazaar.model;

import com.qyfou.bazaar.common.jpa.JpaConverterListJson;
import com.qyfou.bazaar.common.utils.ListStringTypeHandler;
import lombok.Data;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private BigDecimal price;

    private String name;

    private String introduction;

    @Convert(converter = JpaConverterListJson.class)
    @ColumnType(typeHandler = ListStringTypeHandler.class)
    private List<String> tags;

    private Short type;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    private Short inventory;

//    @Column(name = "intro_image")
//    private String introImage;

    @Convert(converter = JpaConverterListJson.class)
    @ColumnType(typeHandler = ListStringTypeHandler.class)
    @Column(name = "intro_image")
    private List<String> introImage;

    private Integer heat;

    @Column(name = "address_id")
    private Long addressId;
}
