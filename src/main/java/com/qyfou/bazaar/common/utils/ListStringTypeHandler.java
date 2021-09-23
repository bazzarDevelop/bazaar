package com.qyfou.bazaar.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ListStringTypeHandler extends BaseTypeHandler<List<String>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (String s : parameter) {
            sb.append("\"").append(s).append("\"").append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        ps.setString(i, sb.toString());
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSON.toJSONString(strings));
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return JSONArray.parseArray(resultSet.getString(s), String.class);
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return JSONArray.parseArray(resultSet.getString(i), String.class);
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return JSONArray.parseArray(callableStatement.getString(i), String.class);
    }
}
