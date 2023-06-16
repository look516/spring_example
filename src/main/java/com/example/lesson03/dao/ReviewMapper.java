package com.example.lesson03.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	public Review selectReviewById(int id); // BO 함수문 복사해서 get -> select로 수정
}