package com.nishubin.work.Controller.index;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET, path="/")
	public String index() {
		return "index";
	}
	@RequestMapping(method=RequestMethod.GET, value="/cms/{path}")
	public String go(@PathVariable String path) {
		return "cms/"+path;
	}
	
}
