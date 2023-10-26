package com.smhrd.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tbl_Board {
	
	//ORM(Object Relation Model)
	// DTO <--> Talble
	// java에서 DTO만 설계해도 Table이 자동 생성
	// NoSQL

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)	// auto_increment
	@Column(insertable = false, updatable = false) // 수정x, 삽입X
	private Long idx;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)	//notnull
	private String writer;
	
	@Column(length = 10000, nullable = false)
	private String content;
	
	@Column
	private String img;
	
	@Column(columnDefinition = "datetime default now()", updatable = false, insertable = false)
	private Date indate;
	
	@Column(columnDefinition = "int default 0", insertable = false)
	private Long count;
	
	
	
}
