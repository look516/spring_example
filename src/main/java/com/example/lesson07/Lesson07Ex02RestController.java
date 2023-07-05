package com.example.lesson07;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.dao.StudentRepository;
import com.example.lesson07.entity.StudentEntity;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {
	
	// !!! 프로젝트 전까지만 BO 생략
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/1")
	public List<StudentEntity> getStudentList() {
		// 1) 전체 조회
		//return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회
		//return studentRepository.findAllByOrderByIdDesc();
		//return StudentRepository.findAllByOrderByName 이런 식으로 name 기준으로도 order by 가능
		
		// 3) id 기준 내림차순 2개만 조회
		//return studentRepository.findTop2ByOrderByIdDesc();
		
		// 4) 이름이 유재석인 데이터 조회 (중복 가능)
		//return studentRepository.findByName("유재석");
		
		// 5) in문으로 일치하는 값 모두 조회 (parameter type : list)
		//return studentRepository.findByNameIn(Arrays.asList("유재석", "조세호"));
		
		// 6) 여러 컬럼값과 일치하는 데이터 조회
		//return studentRepository.findByNameAndDreamJob("조세호", "변호사");
		
		// 7) email 컬럼에 naver 키워드가 포함된 데이터 조회(like문) - %naver%
		// (%naver% 는 원래는 비권장이므로 %naver를 피하고 싶다면 mybatis나 jpa 심화로 or 8번)
		//return studentRepository.findByEmailContaining("naver");
		
		// 8) 이름이 조로 시작하는 데이터 조회(like문) - 조%
		//return studentRepository.findByNameStartingWith("조");
		
		// 9) where id >= 1 and id <= 5
		//	  id between 1 and 5
		// id가 1~5 데이터 조회(between)
		return studentRepository.findByIdBetween(1, 5);
	}
	
	@GetMapping("/2")
	public List<StudentEntity> getStudent() {
		// 장래희망이 래퍼인 데이터 조회
		return studentRepository.findByDreamJob("래퍼");
	}
}