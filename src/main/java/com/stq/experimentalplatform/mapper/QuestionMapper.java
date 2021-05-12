package com.stq.experimentalplatform.mapper;

import com.stq.experimentalplatform.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 尚天琪
 * @since 2021-05-01
 */
public interface QuestionMapper extends BaseMapper<Question> {

    @Select("${sqlStr}")
    List<Map<String, Object>> executeSQL(String sqlStr);


}
