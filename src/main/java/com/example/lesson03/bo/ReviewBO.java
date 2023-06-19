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
	
	
	
	// input: Review
	// output: 성공된 행의 개수 int
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// Double로 해도 됨 (null허용)
	// 이 함수의 파라미터 변수명은 BO의 것이므로 '파라미터'와 '함수 내' 변수만 일치하면 됨. 다른 파일 내 변수명과 일치할 필요없음
	public int addReviewAsField(int storeId, String menu,
			String userName, double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	
	
	// review는 필수값
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
}
