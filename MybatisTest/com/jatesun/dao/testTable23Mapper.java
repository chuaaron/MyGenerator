package com.jatesun.dao;

import com.jatesun.model.testTable23;

public interface testTable23Mapper {
    int deleteByPrimaryKey(String abc);

    int insert(testTable23 record);

    int insertSelective(testTable23 record);

    testTable23 selectByPrimaryKey(String abc);

    int updateByPrimaryKeySelective(testTable23 record);

    int updateByPrimaryKey(testTable23 record);
}