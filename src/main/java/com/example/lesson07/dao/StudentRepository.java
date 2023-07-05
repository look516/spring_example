package com.example.lesson07.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> { // <crud할 entity, pk의 타입> // pk의 타입으로 long 많이 함
	// 순수한 JPA - 내가 직접 구현을 다 해야 함
	/* @PersisteContext
	EntityManager em; */
	
	// Spring Data JPA - 구현 생략
	
	// 내장 메소드들
	// save()
	// findById(id)
	// delete(객체);
	// findAll();
	
	// 메소드명만 잘 지으면 jpa가 entity와 db를 연결하는 쿼리문을 알아서 생성해줌
	// JPQL 메소드로 부르기 => Entity한테 요청한다.
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop2ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob); //메소드명이 쿼리문과 상관있고 파라미터의 변수명은 상관없다.
	public List<StudentEntity> findByEmailContaining(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	// JPQL 직접 작성 => Entity한테 요청한다. (쿼리문은 아니므로 mysql이든 oracle이든 다 동일하게 사용가능)
	// new_student as st 에서 as가 생략됨 // st는 entity 객체 // :dreamJob -> 동적쿼리
	// @Param -> springFramework 로 import // @Param 꼭 있어야 한다! :dreamJob과 "dreamJob"이 매핑
	// from 뒤에 entity명이 와야 한다.
	// @Query(value = "select st from new_student st where st.dreamJob = :dreamJob")
	// public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob); // 메소드명과 관계없이 위 어노테이션으로 수행된다.
	
	// native query => DB한테 요청한다. (DB 쿼리문으로 직접 수행 / mysql이면 그 문법을 지켜야 함)
	@Query(value="select * from new_student where dreamJob=:dreamJob", nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
}
