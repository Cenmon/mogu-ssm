package com.web.manager.mapper;

import com.web.manager.pojo.TTc;
import com.web.manager.pojo.TTcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTcMapper {
    int countByExample(TTcExample example);

    int deleteByExample(TTcExample example);

    int insert(TTc record);

    int insertSelective(TTc record);

    List<TTc> selectByExample(TTcExample example);

    int updateByExampleSelective(@Param("record") TTc record, @Param("example") TTcExample example);

    int updateByExample(@Param("record") TTc record, @Param("example") TTcExample example);
}