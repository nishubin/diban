package com.nishubin.work.Controller.index;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.service.DedeAdminService;

@Controller
public class UserController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private DedeAdminService DedeAdminService;
	@RequestMapping("/cms/login")
	public String login(String account, String password,Map<String, Object> model) {
		RespJson resp = DedeAdminService.login(account, password);
		model.put("resp", resp);
		if(resp.getCode().equals("200")){
			request.getSession(true).setAttribute("admin", resp.getData());
			return "/cms/index";
		}else{
			return "/cms/login";
		}
	}
	@RequestMapping("/user/userList")
	@ResponseBody  
	public RespJson queryUserS(String account, String name){
		return DedeAdminService.queryDedeAdmins(account, name);
	}
}
