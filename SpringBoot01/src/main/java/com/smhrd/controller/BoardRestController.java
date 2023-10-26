package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.Entity.Tbl_Board;
import com.smhrd.Repository.BoardRepository;

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardRepository rep;
	
	
	@RequestMapping("/boardList")
	public List<Tbl_Board> boardList() {
		
		// 게시판 
		 List<Tbl_Board> list= rep.findAll();
		 
		 return list;
		
	}
	
}
