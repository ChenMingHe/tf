package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.excute.Excute;

@Controller
@RequestMapping("/view")
public class TrafficController {
	@RequestMapping("/start")
	public String start() {
		return "start";	
	}

	@Autowired
	private Excute excute;
	@RequestMapping(method=RequestMethod.POST)
	public void creatUser() {
		excute.excute();
	}	
}
