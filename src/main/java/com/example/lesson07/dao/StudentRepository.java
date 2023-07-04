package com.example.lesson07.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> { // <crud할 entity, pk의 타입> // pk의 타입으로 long 많이 함
	// 순수한 JPA - 내가 직접 구현을 다 해야 함
	/* @PersisteContext
	EntityManager em; */
	
	// Spring Data JPA - 구현 생략
	// save() -> 이런 메소드 내장
	
	// findById()
}
