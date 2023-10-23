package com.smhrd.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BoardRestController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	
	@GetMapping("/page")
	public ArrayList<Board> page() {
		
		ArrayList<Board> boardList = boardMapper.boardList();
		
		return boardList;
		
	}
	
	
	
	@GetMapping("/count")
	public Board count(int idx, int count) {
		
		Board board = null;
		try {//Entity에 @Builder를 통해서 setter를 대신한다.
			board = Board.builder().idx(idx).count(count).build();
			
			log.info(board.toString());
			log.info(board.getContent());
			
			int cnt= boardMapper.count(board);
			log.info(String.valueOf(cnt));
			return board;
		} catch (Exception e) {
			System.out.println(e);
			return board;
		}
	}
	
	@GetMapping("/search")
	public  ArrayList<Board> search(String search) {
		System.out.println(search);
		// 1. 파리미터 수집
		// 2. 기능 실행
			ArrayList<Board> list = boardMapper.search(search);
			
		// 데이터 응답	
		return list;
	}
	
	@GetMapping("/chart")
	public ArrayList<Board> chart(){
		//1. 파리미터 수집
		//2. 기능실행
		ArrayList<Board>list = boardMapper.chart();
		
		//3. 데이터 응답
		return list;
		
	}
	
	
	

}
