package com.nishubin.work.service;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishubin.work.bean.resp.PagePlug;
import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.bean.resp.SysConfigs;
import com.nishubin.work.config.EhcacheUtil;
import com.nishubin.work.dao.DedeArctypeMapper;
import com.nishubin.work.model.DedeArctype;
import com.nishubin.work.model.DedeArctypeExample;
@Service
public class DedeArctypeService {
	@Autowired
	private DedeArctypeMapper dedeArctypeMapper;
	
	@Autowired
	private EhcacheUtil ehcacheUtil;
	/**
	 * 查询栏目列表
	 * @param Arctype
	 * @param page
	 * @param rows
	 * @return
	 */
	public PagePlug<DedeArctype> queryDedeArctype(DedeArctype Arctype,Integer page,Integer rows){
		PagePlug<DedeArctype> pageplug = new PagePlug<DedeArctype>();
		DedeArctypeExample example = new DedeArctypeExample();
		DedeArctypeExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(Arctype.getTypename())){
			criteria.andTypenameLike("%"+Arctype.getTypename()+"%");
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			example.setLimit(rows);
			example.setOffset((page-1)*rows);
			pageplug.setPageSize(pageplug.getTotal()%rows==0?pageplug.getTotal()/rows:pageplug.getTotal()/rows+1);
		}
		pageplug.setData(dedeArctypeMapper.selectByExample(example));
		pageplug.setTotal(dedeArctypeMapper.countByExample(example));
		
		return pageplug;
	}
	/**
	 * 修改栏目
	 * @param admin
	 * @return
	 */
	public RespJson modifyArctype(DedeArctype dedeArctype){
		RespJson resp = new RespJson();
		DedeArctype row = dedeArctypeMapper.selectByPrimaryKey((long)dedeArctype.getId());
		if(row!=null){
			dedeArctypeMapper.updateByPrimaryKeySelective(dedeArctype);
			resp.setData(dedeArctype);
		}else{
			resp.setCode("500");
			resp.setData(dedeArctype);
			resp.setMsg("找不到要修改的用户");
		}
		SysConfigs sysConfigs = (SysConfigs) ehcacheUtil.get("com.Menu", "sysConfig");
		sysConfigs.setArcTypes(dedeArctypeMapper.selectAll());
		ehcacheUtil.put("com.Menu", "sysConfig",sysConfigs);
		ehcacheUtil.put("com.Menu", "updateCache", "update");
		return resp;
	}
	public RespJson selectArctype(Integer arctypeId){
		RespJson resp = new RespJson();
		DedeArctype row = dedeArctypeMapper.selectByPrimaryKey((long)arctypeId);
		if(row!=null){
			resp.setData(row);
		}else{
			resp.setCode("500");
			resp.setData(row);
			resp.setMsg("找不到该数据");
		}
		return resp;
	}
}
