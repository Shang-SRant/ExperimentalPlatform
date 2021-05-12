package com.stq.experimentalplatform.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SQLMapper{
    @Select("${sqlStr}")
    List<Map<String, Object>> executeSQL(String sqlStr);


}