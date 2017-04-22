package com.nishubin.work.dao;

import com.nishubin.work.model.DedeSysconfig;
import com.nishubin.work.model.DedeSysconfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DedeSysconfigMapper {
    long countByExample(DedeSysconfigExample example);

    int deleteByExample(DedeSysconfigExample example);

    int deleteByPrimaryKey(String varname);

    int insert(DedeSysconfig record);

    int insertSelective(DedeSysconfig record);

    List<DedeSysconfig> selectByExampleWithBLOBs(DedeSysconfigExample example);

    List<DedeSysconfig> selectByExample(DedeSysconfigExample example);
    
    List<DedeSysconfig> selectAll();

    DedeSysconfig selectByPrimaryKey(String varname);

    int updateByExampleSelective(@Param("record") DedeSysconfig record, @Param("example") DedeSysconfigExample example);

    int updateByExampleWithBLOBs(@Param("record") DedeSysconfig record, @Param("example") DedeSysconfigExample example);

    int updateByExample(@Param("record") DedeSysconfig record, @Param("example") DedeSysconfigExample example);

    int updateByPrimaryKeySelective(DedeSysconfig record);

    int updateByPrimaryKeyWithBLOBs(DedeSysconfig record);

    int updateByPrimaryKey(DedeSysconfig record);
}