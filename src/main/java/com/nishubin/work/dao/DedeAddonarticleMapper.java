package com.nishubin.work.dao;

import com.nishubin.work.model.DedeAddonarticle;
import com.nishubin.work.model.DedeAddonarticleExample;
import com.nishubin.work.model.DedeArchives;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DedeAddonarticleMapper {
    long countByExample(DedeAddonarticleExample example);

    int deleteByExample(DedeAddonarticleExample example);

    int deleteByPrimaryKey(Long aid);

    int insert(DedeAddonarticle record);

    int insertSelective(DedeAddonarticle record);

    List<DedeAddonarticle> selectByExampleWithBLOBs(DedeAddonarticleExample example);

    List<DedeAddonarticle> selectByExample(DedeAddonarticleExample example);

    List<DedeAddonarticle> selectAll();
    
    DedeAddonarticle selectByPrimaryKey(Long aid);

    int updateByExampleSelective(@Param("record") DedeAddonarticle record, @Param("example") DedeAddonarticleExample example);

    int updateByExampleWithBLOBs(@Param("record") DedeAddonarticle record, @Param("example") DedeAddonarticleExample example);

    int updateByExample(@Param("record") DedeAddonarticle record, @Param("example") DedeAddonarticleExample example);

    int updateByPrimaryKeySelective(DedeAddonarticle record);

    int updateByPrimaryKeyWithBLOBs(DedeAddonarticle record);

    int updateByPrimaryKey(DedeAddonarticle record);
}