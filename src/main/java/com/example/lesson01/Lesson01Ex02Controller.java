package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// JSP 뿌리기
@Controller		// RestController 아님 주의, ResponseBody X
public class Lesson01Ex02Controller {
	
	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// jsp의 경로를 리턴한다.
		// "/WEB-INF/jsp/ 		.jsp" 가 prefix suffix에 있으므로 주소가 간단해짐
//		return "/WEB-INF/jsp/lesson01/ex02.jsp"; // jsp 경로
		return "lesson01/ex02";
	}
}
