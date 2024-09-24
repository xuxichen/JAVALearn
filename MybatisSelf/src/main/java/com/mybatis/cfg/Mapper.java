package com.mybatis.cfg;


/**
 * 用于执行封装的Sql语句和结果类型的全限定类名
 */
public class Mapper {
    private String queryString; // sql

    private String resultType; // 实体类型的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
