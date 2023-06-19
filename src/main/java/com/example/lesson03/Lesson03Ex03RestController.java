package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {
	@Autowired
	private ReviewBO reviewBO; // BO만 가져오자 Mapper 가져오지 말자
	
	// http://localhost/lesson03/ex03?id=23&review=도미노피자는 역시 맛있어~
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id") int id,
			@RequestParam("review") String review) { // 리퀘스트 받고
		int row = reviewBO.updateReviewById(id, review); // bo에 요청하고
		return "변경 완료 : " + row; // 요청값을 응답으로 내린다
	}
}
