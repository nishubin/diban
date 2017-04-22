package com.nishubin.work.dao;

import com.nishubin.work.model.DedeArctype;
import com.nishubin.work.model.DedeArctypeExample;
import com.nishubin.work.model.DedeSysconfig;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DedeArctypeMapper {
    long countByExample(DedeArctypeExample example);

    int deleteByExample(DedeArctypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DedeArctype record);

    int insertSelective(DedeArctype record);

    List<DedeArctype> selectByExampleWithBLOBs(DedeArctypeExample example);

    List<DedeArctype> selectByExample(DedeArctypeExample example);
    
    List<DedeArctype> selectAll();

    DedeArctype selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DedeArctype record, @Param("example") DedeArctypeExample example);

    int updateByExampleWithBLOBs(@Param("record") DedeArctype record, @Param("example") DedeArctypeExample example);

    int updateByExample(@Param("record") DedeArctype record, @Param("example") DedeArctypeExample example);

    int updateByPrimaryKeySelective(DedeArctype record);

    int updateByPrimaryKeyWithBLOBs(DedeArctype record);

    int updateByPrimaryKey(DedeArctype record);
}