package com.nishubin.work.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nishubin.work.bean.resp.SysConfigs;
import com.nishubin.work.config.EhcacheUtil;
import com.nishubin.work.service.DedeSysConfigService;
import com.qiniu.util.Json;

public class DefauInterceptor extends HandlerInterceptorAdapter  {
	@Autowired
	private DedeSysConfigService dedeSysConfigService; 
	@Autowired
	private EhcacheUtil ehcacheUtil;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
		if(request.getSession().getAttribute("admin") == null&&request.getServletPath().startsWith("/cms")){
			if(!request.getServletPath().startsWith("/cms/login")){
				response.sendRedirect("/cms/login");
			}
		}
		if(request.getSession().getAttribute("basepath") == null) {
			String path = request.getContextPath();  
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
			request.getSession(true).setAttribute("basepath", basePath);
		}
		if(request.getSession().getAttribute("sysConfig") == null) {
			 if (dedeSysConfigService == null) {//解决service为null无法注入问题 
		         System.out.println("dedeSysConfigService is null!!!"); 
		         BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
		         dedeSysConfigService = (DedeSysConfigService) factory.getBean("dedeSysConfigService"); 
		      } 
			 
			 if (ehcacheUtil == null) {//解决service为null无法注入问题 
		         System.out.println("ehcacheUtil is null!!!"); 
		         BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
		         ehcacheUtil = (EhcacheUtil) factory.getBean("ehcacheUtil"); 
		      } 
			 if(ehcacheUtil.get("com.Menu", "sysConfig")==null){
				 System.out.println("获取数据");
				 SysConfigs sysConfigs = dedeSysConfigService.loadData();
				 ehcacheUtil.put("com.Menu", "sysConfig", sysConfigs);
			 }
			request.getSession(true).setAttribute("sysConfig",ehcacheUtil.get("com.Menu", "sysConfig"));
		}
		if("update".equals(ehcacheUtil.get("com.Menu", "updateCache"))) {
			request.getSession(true).setAttribute("sysConfig",ehcacheUtil.get("com.Menu", "sysConfig"));
			ehcacheUtil.put("com.Menu", "updateCache", "");
		}
		return true;
	}
	
}
