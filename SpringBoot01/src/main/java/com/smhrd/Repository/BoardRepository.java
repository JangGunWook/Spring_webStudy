package com.smhrd.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smhrd.Entity.Tbl_Board;

public interface BoardRepository extends JpaRepository<Tbl_Board, Long>{
	
	// 2. 만약에 다른 기능이 필요하다면
	//select * from tbl_board where title = #{title} and writer=#{writer};
	// NoSQL, 메서드만 만들것
	// 이름 규칙 잘 지켜서 ---> 카멜기법으로 작성
	public List<Tbl_Board> findByTitleAndWriter(String title, String writer);
	
	// select * from tble_board where idx = #{idx} and title = #{title}
	public Tbl_Board findByIdxAndTitle(Long idx, String title);
	
	// 5~10번까지만
	// select * from tbl_board
	// where rownum between 5 and 10
	//@Query("sql")
	// public...method()

}
