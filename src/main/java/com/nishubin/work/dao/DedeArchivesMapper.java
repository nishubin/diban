package com.nishubin.work.dao;

import com.nishubin.work.model.DedeArchives;
import com.nishubin.work.model.DedeArchivesExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DedeArchivesMapper {
    long countByExample(DedeArchivesExample example);

    long deleteByExample(DedeArchivesExample example);

    long deleteByPrimaryKey(Long id);

    long insert(DedeArchives record);

    long insertSelective(DedeArchives record);

    List<DedeArchives> selectByExample(DedeArchivesExample example);
    
    List<DedeArchives> selectAll();

    DedeArchives selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DedeArchives record, @Param("example") DedeArchivesExample example);

    int updateByExample(@Param("record") DedeArchives record, @Param("example") DedeArchivesExample example);

    int updateByPrimaryKeySelective(DedeArchives record);

    int updateByPrimaryKey(DedeArchives record);
}