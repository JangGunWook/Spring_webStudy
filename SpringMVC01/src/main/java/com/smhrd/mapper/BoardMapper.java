package com.smhrd.mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Board;

@Mapper		//scan할 때, 알아볼 수 있게끔 어노테이션 달아주기
public interface BoardMapper  {
	
	// DBCP(DataBase Connection Pool)
	// 미리 정해진 갯수만큼만 Connection을 생성
	// 기능 실행시 빌려갔다가 종료후 반납하는 구조
	 
	
	// 달라진 점
	// 1. 추상 메소드만으로 정의
	// 2. interface로 작성
	// 3. xml 파일과 interface파일의 이름이 같아야함
	// 추상메소드
	public ArrayList<Board> boardList();
	
	
	public int write(Board board);
	
	public int delete(int idx);
	
	public Board detail(int idx);
	
	public int update(Board board);
	
	public int count(Board board);
	
	public ArrayList<Board> search(String search);
	
	public ArrayList<Board> chart();

}
