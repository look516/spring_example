package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	public Review selectReviewById(int id); // BO 함수문 복사해서 get -> select로 수정
	
	// insert일 때 mybatis가 성공한 행의 개수를 리턴해준다. (따라서 리턴값이 int타입 가능)
	public int insertReview(Review review); // 한 개의 객체이므로 @param을 이용해 map으로 만들 필요 없음
	
	public int insertReviewAsField(
			// 파라미터가 2개 이상인 경우 @Param을 통해
			// 하나의 맵으로 만들고 xml에 전달한다.
			@Param("storeId") int storeId, // 변수명(int storeId)은 다른 파일과 아무 상관이 없다.
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") double point,
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
}