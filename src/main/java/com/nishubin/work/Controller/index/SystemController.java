package com.nishubin.work.Controller.index;



import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.service.DedeSysConfigService;
@Controller
public class SystemController {
	@Autowired
	private DedeSysConfigService dedeSysConfigService;
	
	@RequestMapping("/cms/selectSystem")
	@ResponseBody 
	public RespJson selectSystem(){
		return dedeSysConfigService.getSystem();
	}
	
	
	@RequestMapping("/cms/updateSystem")
	@ResponseBody
	public RespJson updateSystem(@RequestParam Map<String,String> map){
		return dedeSysConfigService.updateSystem(map);
	}
	
}
