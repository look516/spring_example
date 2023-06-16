package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewMapper;
import com.example.lesson03.domain.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	// input: id
	// output: id에 일치하는 Review 단건 => 컨트롤러한테
	
	// RequestParam 4번째에서
	// 쿼리 스트링 안 붙이고 주소 입력 시
	// 여기에서 int가 아니라 null이 들어와서 에러
	// 해결하려면 분기문
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}
}
