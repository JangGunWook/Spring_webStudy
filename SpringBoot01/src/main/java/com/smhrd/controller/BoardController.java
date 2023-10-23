package com.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/list";
	}
	
	
	
	@RequestMapping("/list")
	public String list() {
		
		// 2. 기능 실행
		
		return "boardList";
	}

}
