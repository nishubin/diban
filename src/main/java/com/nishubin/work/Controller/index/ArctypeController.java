package com.nishubin.work.Controller.index;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nishubin.work.bean.resp.PagePlug;
import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.model.DedeArctype;
import com.nishubin.work.service.DedeArctypeService;

@Controller
public class ArctypeController {
	@Autowired
	private DedeArctypeService DedeArctypeService;
	
	@RequestMapping("/cms/listArctype")
	@ResponseBody  
	public PagePlug<DedeArctype> queryArctypeS(DedeArctype Arctype,Integer page,Integer rows){
		return DedeArctypeService.queryDedeArctype(Arctype,page,rows);
	}
	
	
	@RequestMapping("/cms/modifyArctype")
	@ResponseBody
	public RespJson modifyArctype(DedeArctype arctype){
		return DedeArctypeService.modifyArctype(arctype);
	}
	
	
	@RequestMapping("/cms/seleteArctype")
	@ResponseBody
	public RespJson seleteArctype(Integer arctypeId){
		return DedeArctypeService.selectArctype(arctypeId);
	}
	
}
