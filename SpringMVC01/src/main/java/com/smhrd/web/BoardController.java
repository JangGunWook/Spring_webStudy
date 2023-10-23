package com.smhrd.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

// Controller(POJO) 생성
// 1. scan하고 있는 폴더 내에서 Class 파일 만들기
// 2. @Controller 어노테이션을 통해, POJO임을 알려주기
@Controller
public class BoardController {
	
	@Autowired	//spring 메모리에 있는 bean 중에서, 집어넣어줄 수 있는 객체를 자동으로 주입
	private BoardMapper boardMapper;
	
//	@Autowired
//	Board board;
//	
	// 어떤? 요청 받았을 때, 무슨 일을 할지?
	// http://localhost:8083/web/list
	@RequestMapping("/list")	// URLMapping 
	public String list() {
		// 1. 파라미터 수집
//		// 2. 기능 실행---> DB에 저장된 모든 게시글 가져오기
		// ArrayList<Board> boardList = boardMapper.boardList();
//		
//		// 객체바인딩
		// model.addAttribute("boardList", boardList);
//		
		// 3. View 선택 --> boardList.jsp
		
		return "boardList";
		
	}
	
	@RequestMapping("/goWrite")
	public String goWrite() {
		
		return "boardWrite";
	}
	
	@ResponseBody
	@RequestMapping("/write")
	public String write(Board board) {
		
		// 1. 파라미터 수집
		// Spring 달라진점 : 메소드 매개변수에 수집할 변수만 선언 해주면 자동으로 수집과정이 일어난다.
		// 1) 여러개의 데이터가 전송되었을 때,
		// 조건 : Table 컬럼 이름 == DTO 필드 변수 명 == input의 name값이 같아야 함
		//		 기본생성자가 있어야만 함.
		// 2) 각각의 데이터를 따로 받아올 때
		// 조건 : 매개변수에 선언한 변수 명 == input name
		// int 타입으로 형변환도 자동으로 일어난다.
		// 만약에 input name과 다른 이름의 변수로 수집하고 싶다면 @RequestParam("name")를 붙이면 된다
		
		//2. 기능실행 - 수집한 데이터를 Board 테이블에 저장 
		
		
		try {
			int cnt = boardMapper.write(board);
			if(cnt>0){
				System.out.println("insert완료");
			}
		} catch (Exception e) {
			System.out.println("insert실패");
		}
		
		// 3. View
		// Controller --> Controller로 다시 요청을 보내는 상황
		// redirect방식을 사용해야함
		return "redirect:/list";
	}

	
	
	
	@RequestMapping("/delete")
	public String delete(int idx) {
		
		try {
			int cnt = boardMapper.delete(idx);
			if(cnt>0){
				System.out.println("delete 완료");
			}
		} catch (Exception e) {
			System.out.println("delet 실패");
		}
		
		return "redirect:/list";
	}
	
	@RequestMapping("/detail")
	public String detial(@RequestParam("idx")int idx, Model model ) {
		
		try {
			System.out.println(idx);
			Board detail = boardMapper.detail(idx);
			System.out.println("detail : "+detail);
			
			model.addAttribute("detail", detail);
			
			System.out.println("detail 성공");
		} catch (Exception e) {
			System.out.println("detail 실패");
		}
		
		return "boardDetail";
		
	}
	
	// GetMapping("/URLMapping)
	// POSTMapping("/URLMapping)
	// 400에러 --> 수집해야하는 데이터가 제대로 보내지지 않는 경우
	// 404에러 ===>URLMapping이 잘못됨, jsp 파일 이름이 틀린 경우
	// 405에러 ===>허용되지 않은 접근 : 지정해둔 방식과 다른 방식이 요청이 이루어진 경우
	@RequestMapping("/update")
	public String update(Board board) {
		
		System.out.println("update : " + board);
		
		try {
			int cnt = boardMapper.update(board);
			System.out.println("cnt : " + cnt);
			if(cnt>0) {
				System.out.println("update성공");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("update실패");
		}
		
		return "redirect:/detail?idx="+board.getIdx();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
