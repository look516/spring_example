package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.StudentMapper;
import com.example.lesson04.domain.Student;
import com.example.lesson07.dao.StudentRepository;
import com.example.lesson07.entity.StudentEntity;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	// lesson07 ex01
	@Autowired
	private StudentRepository studentRepository;
	
	
	
	
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	// lesson07 ex01 create
	// parameter type을 달리 해서 overloading
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		// setter는 중간에 끊길 수가 있음 builder는 한번에
		
		StudentEntity student = studentRepository.save(
					StudentEntity.builder()
					.name(name)
					.phoneNumber(phoneNumber)
					.email(email)
					.dreamJob(dreamJob)
					.createdAt(ZonedDateTime.now()) // 자바가 채우므로 @UpdateTimestamp 생략 가능 (DB가 채움)
					.build()
				);
		return student;
	}
	
	// lesson07 ex01 update
	// input: id, dreamJob
	// output: StudentEntity
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// update라는 함수가 없고, save(새로운 객체)를 해야 함
		// 만약 모든 필드를 채우지 못한 상태에서 실행한다면 에러나나? -> 경우의 수, 흐름 생각해보기
		
		// 기존 데이터 조회(id로)
		// optional이라는 클래스로 리턴 -> null일 때도 처리가 가능한 클래스
		// orElse -> entity면 entity로 받아오고 null이면 null로 받아오겠다.
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// entity 변경(dreamJob 변경) => save
		if (student != null) {
			student = student.toBuilder() // toBuilder는 기존값 유지하고 일부만 변경
				.dreamJob(dreamJob)
				.build(); // save에 바로 넣어도 된다.
			
			student = studentRepository.save(student); // 다시 셀렉트된 것을 받아온다. // update
		}
		return student;
	}
	
	// lesson07 ex01 delete
	// nullable의 한 데이터만 삭제하고 싶으면 update?
	// 데이터 삭제 후에는 데이터를 가져올 수 없으므로 가져온 다음에 삭제하자.
	public void deleteStudentById(int id) {
		// 방법1) StudentEntity 자료형
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법2) Optional 자료형 (nullable임을 의미)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s)); // 람다식 java14부터
	}
}