package com.nishubin.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishubin.work.dao.DedeArctypeMapper;
import com.nishubin.work.model.DedeArctype;
@Service
public class DedeArctypeService {
	@Autowired
	private DedeArctypeMapper dedeArctypeMapper;
	public List<DedeArctype> queryDedeArctype(){
		return dedeArctypeMapper.selectAll();
	}
}
