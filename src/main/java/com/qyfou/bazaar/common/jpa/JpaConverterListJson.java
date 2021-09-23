package com.qyfou.bazaar.common.jpa;

import com.alibaba.fastjson.JSON;

import javax.persistence.AttributeConverter;
import java.util.List;

public class JpaConverterListJson implements AttributeConverter<Object, String> {
    @Override
    public String convertToDatabaseColumn(Object o) {
        List<String> list = (List<String>) o;
        return JSON.toJSONString(o);
    }

    @Override
    public Object convertToEntityAttribute(String s) {
        return JSON.parseArray(s);
    }
}
