package com.qyfou.bazaar.service;

import java.util.List;
import java.util.Map;

public interface GoodsComment {
    List<Map<String, Object>> getComment(Integer type, Long typeId, int current, int count);//独有操作

    Integer getCommentNum(Integer type, Long typeId);
}
