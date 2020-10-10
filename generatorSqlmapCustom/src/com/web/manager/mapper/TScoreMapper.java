package com.web.manager.mapper;

import com.web.manager.pojo.TScore;
import com.web.manager.pojo.TScoreExample;
import com.web.manager.pojo.TScoreKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TScoreMapper {
    int countByExample(TScoreExample example);

    int deleteByExample(TScoreExample example);

    int deleteByPrimaryKey(TScoreKey key);

    int insert(TScore record);

    int insertSelective(TScore record);

    List<TScore> selectByExample(TScoreExample example);

    TScore selectByPrimaryKey(TScoreKey key);

    int updateByExampleSelective(@Param("record") TScore record, @Param("example") TScoreExample example);

    int updateByExample(@Param("record") TScore record, @Param("example") TScoreExample example);

    int updateByPrimaryKeySelective(TScore record);

    int updateByPrimaryKey(TScore record);
}