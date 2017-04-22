package com.nishubin.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishubin.work.dao.DedeArchivesMapper;
import com.nishubin.work.model.DedeArchives;
@Service
public class DedeArchivesService {
	@Autowired
	private DedeArchivesMapper dedeArchivesMapper;
	public List<DedeArchives> queryDedeArchives(){
		return dedeArchivesMapper.selectAll();
	}
}
