package com.nishubin.work.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.dao.DedeAdminMapper;
import com.nishubin.work.model.DedeAdmin;
import com.nishubin.work.model.DedeAdminExample;
@Service
public class DedeAdminService {
	@Autowired
	private DedeAdminMapper dedeAdminMapper;
	public RespJson login(String account,String password){
		RespJson resp = new RespJson();
		if(StringUtils.isEmpty(account)||StringUtils.isEmpty(password)){
			resp.setCode("500");
			resp.setMsg("用户名或密码不能为空");
			return resp;
		}
		DedeAdmin admin = dedeAdminMapper.selectByAccountPassword(account, password);
		if(admin!=null){
			resp.setData(admin);
			resp.setMsg("登录成功");
		}else{
			resp.setCode("500");
			resp.setData(admin);
			resp.setMsg("用户名或者密码不正确");
		}
		return resp;
	}
	
	public RespJson modifyAdmin(DedeAdmin admin){
		RespJson resp = new RespJson();
		dedeAdminMapper.updateByPrimaryKeySelective(admin);
		resp.setData(admin);
		return resp;
	}
	public RespJson queryDedeAdmins(String account,String username){
		RespJson resp = new RespJson();
		List<DedeAdmin> list = null;
		DedeAdminExample example = new DedeAdminExample();
		DedeAdminExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(account)){
			criteria.andAccountLike("%"+account+"%");
		}
		if(!StringUtils.isEmpty(username)){
			criteria.andNameLike("%"+username+"%");
		}
		list = dedeAdminMapper.selectByExample(example);
		resp.setData(list);
		return resp;
	}
	public RespJson createDedeAdmins(DedeAdmin admin){
		RespJson resp = new RespJson();
		if(StringUtils.isEmpty(admin.getAccount())){
			resp.setCode("500");
			resp.setData(admin);
			resp.setMsg("用户账号不能为空");
			return resp;
		}
		if(StringUtils.isEmpty(admin.getName())){
			resp.setCode("500");
			resp.setData(admin);
			resp.setMsg("用户名字不能为空");
			return resp;
		}
		if(StringUtils.isEmpty(admin.getPassword())){
			resp.setCode("500");
			resp.setData(admin);
			resp.setMsg("用户密码不能为空");
			return resp;
		}
		dedeAdminMapper.insertSelective(admin);
		return resp;
	}
	
}
