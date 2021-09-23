package com.qyfou.bazaar.model;

import com.qyfou.bazaar.common.jpa.JpaConverterListJson;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "open_id")
    private String openId;

    private String portrait;

    private String name;

    private Long birthday;

    @Convert(converter = JpaConverterListJson.class)
    private List<String> tags;

    private Integer follows;

    private Integer fans;

    private Short type;
}
