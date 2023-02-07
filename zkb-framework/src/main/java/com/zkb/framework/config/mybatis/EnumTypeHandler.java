package com.zkb.framework.config.mybatis;

import com.zkb.framework.config.EnumValue;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EnumTypeHandler <T extends Enum<T> & EnumValue> extends BaseTypeHandler<T> {

    private final Class<T> type;

    public EnumTypeHandler(Class<T> type) {
        this.type = type;
    }


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException {
        Object v = t.toValue();
        if(jdbcType == null){
            preparedStatement.setObject(i,v);
        }else{
            preparedStatement.setObject(i,v,jdbcType.TYPE_CODE);
        }
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return valueOf(resultSet.getString(s));
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return valueOf(resultSet.getString(i));
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return valueOf(callableStatement.getString(i));
    }

    private T valueOf(String s) {
        return s == null ? null : EnumValue.valueOf(type, s);
    }
}
