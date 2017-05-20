package com.nishubin.work.Controller.index;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nishubin.work.bean.resp.SysConfigs;
import com.nishubin.work.model.DedeArctype;


@Controller
public class IndexArticleController {
	@Autowired
	private HttpServletRequest request;
	@RequestMapping(method=RequestMethod.GET, value="/view/{path}/{pid}/{childId}")
	public String go(@PathVariable String path,@PathVariable Integer pid,@PathVariable Integer childId, Long infoId,Integer page ,Map<String, Object> model) {
		SysConfigs sysConfigs = (SysConfigs) request.getSession().getAttribute("sysConfig");
		DedeArctype arctye = sysConfigs.getArcTye(pid);
		List<DedeArctype> childArcTyes = sysConfigs.getChildArcTyes(pid);
		DedeArctype childArcTye = null;
		if(childArcTyes!=null&&childArcTyes.size()>0){
			childArcTyes = sysConfigs.getChildArcTyes(pid);
			if(childId==null||childId==0){
				childArcTye = childArcTyes.get(0);
			}else{
				childArcTye = sysConfigs.getArcTye(childId);
			}
		}
		if(page==null||page==0){
			page=1;
		}
		if(infoId!=null){
			model.put("arcTyeInfo",sysConfigs.queryId(infoId));
		}
		model.put("page",page);
		model.put("arctye",arctye);
		model.put("childArcTye",childArcTye);
		model.put("childArcTyes",childArcTyes);
		return path;
	}
}
