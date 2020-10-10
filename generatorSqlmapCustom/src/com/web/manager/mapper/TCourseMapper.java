package com.web.manager.mapper;

import com.web.manager.pojo.TCourse;
import com.web.manager.pojo.TCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCourseMapper {
    int countByExample(TCourseExample example);

    int deleteByExample(TCourseExample example);

    int deleteByPrimaryKey(Integer nCourseId);

    int insert(TCourse record);

    int insertSelective(TCourse record);

    List<TCourse> selectByExample(TCourseExample example);

    TCourse selectByPrimaryKey(Integer nCourseId);

    int updateByExampleSelective(@Param("record") TCourse record, @Param("example") TCourseExample example);

    int updateByExample(@Param("record") TCourse record, @Param("example") TCourseExample example);

    int updateByPrimaryKeySelective(TCourse record);

    int updateByPrimaryKey(TCourse record);
}