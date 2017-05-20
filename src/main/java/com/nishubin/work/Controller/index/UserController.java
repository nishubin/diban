package com.nishubin.work.Controller.index;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.model.DedeAdmin;
import com.nishubin.work.service.DedeAdminService;
import com.qiniu.util.Auth;

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
	
	@RequestMapping("/cms/logout")
	@ResponseBody 
	public RespJson logout() {
		RespJson respJson = new RespJson();
		request.getSession(true).removeAttribute("admin");
		return respJson;
	}
	
	@RequestMapping("/cms/listUser")
	@ResponseBody  
	public RespJson queryUserS(String account, String name){
		return DedeAdminService.queryDedeAdmins(account, name);
	}
	
	@RequestMapping("/cms/createUser")
	@ResponseBody  
	public RespJson createUserS(DedeAdmin admin){
		return DedeAdminService.createDedeAdmins(admin);
	}
	
	@RequestMapping("/cms/modifyUser")
	@ResponseBody
	public RespJson modifyUser(DedeAdmin admin){
		RespJson resp = DedeAdminService.modifyAdmin(admin);
		request.getSession(true).setAttribute("admin", resp.getData());
		return resp;
	}
	@RequestMapping("/cms/getUploadToken")
	@ResponseBody
	public Map<String,String> getToken(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("uptoken", Auth.create("1bX0HL3vgMPixKJMIidctGiI0yBst47EvW-SWdnl", "d2UfcZxQmkXTchdcscE2LO_V_pqGIfsebawBZTrz").uploadToken("tairan"));
		return map;
	}
	
	
}
