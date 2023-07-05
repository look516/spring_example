package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C:Create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber = "010-1111-2222";
		String email = "kbd@kakao.com";
		String dreamJob = "개발자";
		
		StudentEntity student = studentBO.addStudent(name, phoneNumber, email, dreamJob);
		//student.getId() => 이전에 insert한 id 얻어냄. usedgeneratedkey?가져올 필요없음
		return student;	// @ResponseBody + return 객체 => JSON
	}
	
	// U:Update
	@GetMapping("/2")
	public StudentEntity update() {
		// id가 4번인 dreamJob 변경 => "디자이너"
		StudentEntity student = studentBO.updateStudentDreamJobById(4, "디자이너");
		return student;
	}
	
	// D:Delete
	// 삭제된 행이 무엇이었는지 가져오고 싶다면?
	@GetMapping("/3")
	public String delete() {
		// id:3, 4
		studentBO.deleteStudentById(4);
		return "삭제 완료";
	}
}