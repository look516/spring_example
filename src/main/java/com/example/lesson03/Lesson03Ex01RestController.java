package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;

	// http://localhost/lesson03/ex01?id=3
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// value 딱 하나만 넣을 때 value 생략 가능, 속성 2개 이상일 때는 value 꼭 써줘야 함
			@RequestParam("id") int id // 필수 파라미터
			//@RequestParam(value = "id") int id // 필수 파라미터
			//@RequestParam(value = "id", required = true) int id // required=true는 필수 파라미터, false는 필수 파라미터가 아님(nullable)
			//@RequestParam(value = "id", required = false) Integer id // 비필수 파라미터 (null이 들어올 수도 있어서 Integer)
			//@RequestParam(value = "id", defaultValue = "1") int id // 비필수 파라미터지만 디폴트값:1
			) {
		return reviewBO.getReviewById(id);
	}
}
