package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Board {
		// DTO: Data Transfer Object
		// 계층간 데이터 전송시에 데이터를 담은 용도
	
	
		private int idx;
		private String title;  
		private String writer;  
		private String content;  
		private String indate;
		private int count;
}
