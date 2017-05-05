package com.nishubin.work.Controller.index;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nishubin.work.bean.resp.PagePlug;
import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.model.DedeArchives;
import com.nishubin.work.service.DedeArchivesService;

@Controller
public class ArchivesController {
	@Autowired
	private DedeArchivesService DedeArchivesService;
	
	
	@RequestMapping("/cms/listArchives")
	@ResponseBody  
	public PagePlug<DedeArchives> queryArchivesS(DedeArchives archives,Integer page,Integer rows){
		return DedeArchivesService.queryDedeArchives(archives,page,rows);
	}
	
	@RequestMapping("/cms/createArchives")
	@ResponseBody  
	public RespJson createArchivesS(DedeArchives archives){
		return DedeArchivesService.createArchives(archives);
	}
	
	@RequestMapping("/cms/modifyArchives")
	@ResponseBody
	public RespJson modifyArchives(DedeArchives archives){
		return DedeArchivesService.modifyArchives(archives);
	}
	
	
	@RequestMapping("/cms/deleteArchives")
	@ResponseBody
	public RespJson deleteArchives(Integer archivesId){
		return DedeArchivesService.deleteArchives(archivesId);
	}
	
	@RequestMapping("/cms/seleteArchives")
	@ResponseBody
	public RespJson seleteArchives(Integer archivesId){
		return DedeArchivesService.selectArchives(archivesId);
	}
}
