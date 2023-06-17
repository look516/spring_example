package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")
@Controller // Spring bean 스프링 컨테이너 안 스프링빈(객체)들을 관리해준다.
// ctrl + shift + r로 파일 바로 찾기
public class Lesson01Ex01Controller {
	
	// return String: HTML
	// http://localhost:8080/lesson01/ex01/1
	@RequestMapping("/1")  // 주소 매핑
	@ResponseBody // 리턴되는 결과값을 HTML Response body에 넣어 보낸다. 어노테이션 순서 상관없음
	public String ex01_1() {
		String text = "예제1번<br>문자열을 response body로 보내는 예제";
		return text;
	}
	
	// return Map: JSON String 
	// http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/2")
	// int나 void로 리턴 가능?
	public @ResponseBody Map<String, Object> ex01_2() { //어노테이션 여기 붙이는 건 옛방식
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 10);
		map.put("orange", 125);
		map.put("grape", 50);
		// 자바의 맵과 자바스크립트의 오브젝트는 다르다.
		// {"apple"=4...} => Map
		// {"apple":4...} => 자바스크립트
		// 맵인데 왜 자바스크립트 형태로 나오냐?
		// responsebody에 의해?? json형태로 응답내려가기 때문
		
		// String 이외의 객체를 리턴할 때 (key-value쌍으로 되어있는?)
		// Map을 리턴하면 JSON String 나타난다. (JSON은 객체아님! String 덩어리임)
		// jackson 라이브러리가 동작되기 때문
		// spring-boot-starter-web에 들어있는 라이브러리(의존성 라이브러리)
		// gradle dependencies에 없다면 jackson lib gradle 등으로 검색해서 추가하면 됨 (mvnrepository.com 사이트 참고)
		
		// {"키"=값} => JAVA Map
		// map을 리턴하면 JSON으로 나타난다. web starter 안에 jackson 라이브러리가 있기 때문
		return map;
	}
	
	// jsp db도 점검해보자
}