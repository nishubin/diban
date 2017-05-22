package com.nishubin.work.service;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.bean.resp.SysConfigs;
import com.nishubin.work.config.EhcacheUtil;
import com.nishubin.work.dao.DedeAddonarticleMapper;
import com.nishubin.work.dao.DedeArchivesMapper;
import com.nishubin.work.dao.DedeArctypeMapper;
import com.nishubin.work.dao.DedeSysconfigMapper;
import com.nishubin.work.model.DedeSysconfig;

@Service
public class DedeSysConfigService {
	
	@Autowired
	private DedeSysconfigMapper dedeSysconfigMapper;
	
	@Autowired
	private DedeArchivesMapper dedeArchivesMapper;
	
	@Autowired
	private DedeArctypeMapper dedeArctypeMapper;
	
	@Autowired
	private DedeAddonarticleMapper dedeAddonarticleMapper;
	
	
	public SysConfigs  loadData(){
		SysConfigs sysconfigDate = new SysConfigs();
		sysconfigDate.setArcTypes(dedeArctypeMapper.selectAll());
		sysconfigDate.setConfigs(dedeSysconfigMapper.selectAll());
		sysconfigDate.setDedeAddonarticles(dedeAddonarticleMapper.selectAll());
		sysconfigDate.setDedeArchives(dedeArchivesMapper.selectAll());
		return sysconfigDate;
	}
	
	public RespJson getSystem(){
		RespJson resp = new RespJson();
		String[] varnames ={"cfg_webname","cfg_rxdianhua","cfg_zxdianhua","cfg_kfqq","cfg_logo","cfg_wxewm"};
		Map<String,String> map = new HashMap<String,String>();
		List<DedeSysconfig> sysConfigs = dedeSysconfigMapper.selectVarnames(varnames);
		for(DedeSysconfig sysconfig :sysConfigs){
			map.put(sysconfig.getVarname(), sysconfig.getValue());
		}
		resp.setData(map);
		return resp;
	}
	
	public RespJson updateSystem(Map<String,String> map){
		RespJson resp = new RespJson();
		Set<String> key = map.keySet();
        for (Iterator it = key.iterator(); it.hasNext();) {
        	String s = (String) it.next();
        	dedeSysconfigMapper.updateValue(s, map.get(s));
        }
        SysConfigs sysConfigs = (SysConfigs) EhcacheUtil.getInstance().get("com.Menu", "sysConfig");
		sysConfigs.setConfigs(dedeSysconfigMapper.selectAll());
		EhcacheUtil.getInstance().put("com.Menu", "sysConfig",sysConfigs);
		EhcacheUtil.getInstance().put("com.Menu", "updateCache", "update");
		return resp;
	}
}
