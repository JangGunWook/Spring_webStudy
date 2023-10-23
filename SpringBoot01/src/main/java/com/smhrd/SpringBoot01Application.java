package com.smhrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot01Application {
	
	// @AutoConfiguration :
	// Spring을 시작하기 위한 다양한 설정 Class들이 자동으로 세팅됨
	// application.properties를 보고, 지정한 설정들을 반영 시켜줌
	
	// @ComponentScan : 
	// 지정된 패키지를 스캔하고, 어노테이션(@)이 붙은 Class들을 Spring 메모리 생성
	// 기본으로, Apllication Class가 있는 패키지를 Scan
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
	}

}
