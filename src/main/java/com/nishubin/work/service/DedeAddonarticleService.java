package com.nishubin.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishubin.work.dao.DedeAddonarticleMapper;
import com.nishubin.work.model.DedeAddonarticle;

@Service
public class DedeAddonarticleService {
	@Autowired
	private DedeAddonarticleMapper dedeAddonarticleMapper;
	public List<DedeAddonarticle> queryDedeAddonarticle(){
		return dedeAddonarticleMapper.selectAll();
	}
}
