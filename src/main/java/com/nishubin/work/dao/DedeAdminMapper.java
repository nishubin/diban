package com.nishubin.work.dao;

import com.nishubin.work.model.DedeAdmin;
import com.nishubin.work.model.DedeAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DedeAdminMapper {
    long countByExample(DedeAdminExample example);

    int deleteByExample(DedeAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DedeAdmin record);

    int insertSelective(DedeAdmin record);

    List<DedeAdmin> selectByExample(DedeAdminExample example);

    DedeAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DedeAdmin record, @Param("example") DedeAdminExample example);

    int updateByExample(@Param("record") DedeAdmin record, @Param("example") DedeAdminExample example);

    int updateByPrimaryKeySelective(DedeAdmin record);

    int updateByPrimaryKey(DedeAdmin record);
    
    DedeAdmin selectByAccountPassword(@Param("account") String account,@Param("password") String password);
}