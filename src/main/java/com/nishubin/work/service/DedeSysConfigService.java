package com.nishubin.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishubin.work.bean.resp.SysConfigs;
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
}
