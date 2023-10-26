package com.smhrd.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.Entity.Tbl_Board;
import com.smhrd.Mapper.UserMapper;
import com.smhrd.Repository.BoardRepository;

@Controller
public class BoardController {
	
	
	@Autowired
	BoardRepository repo;
	
	@Autowired
	UserMapper usermapper;
	
	
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/list";
	}
	
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		// 2. 기능 실행
		// findAll : 전체목록 가져오기
		List<Tbl_Board> list = usermapper.abcd();		
	
		
		
		model.addAttribute("list",list);
		
		return "boardList";
	}
	
	@RequestMapping("/goWrite")
	public String goWrite() {
		return "boardWrite";
	}
	
	
	
	@RequestMapping("/write")
	public String write(Tbl_Board board, MultipartFile file ) {
		// 1. 데이터 수집
		
		// 1-1. 이름 중복
		
		// 2. 경로
		final String PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";
		System.out.println( System.getProperty("user.dir"));
		
		// 저장할 파일 이름 결정(중복제거)
		UUID uuid = UUID.randomUUID();	// 랜덤한 문자열 만들기
		String fileName = uuid + "_" + file.getOriginalFilename();
		// 예시 : A1B2C3D4
		// >> A1B2C3D4_cat.jpg
		
		// 3. 파일 저장 
		try {
			// 3-1) 경로에 비어있는 파일 만들기
			File f = new File(PATH + fileName);
			// 3-2) 만들어둔 파일에 옮겨 담기0
			file.transferTo(f);
			
			// DTO에 파일 이름을 집어넣기
			board.setImg(fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// DB에 수집한 정보 저장
		repo.save(board);
		
		return "redirect:/list";
	}
	
	
	
	
	

}
