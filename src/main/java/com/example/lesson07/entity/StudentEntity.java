package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString	// toString override 객체 주소 대신 필드 출력
@AllArgsConstructor	// 모든 필드를 인자값으로 받는 생성자
@NoArgsConstructor // 파라미터 없는 기본 생성자
@Builder(toBuilder = true)	// setter 대용 // toBuilder = true 몇 개의 필드만 바꾸는 게 허용됨
@Getter		// getter
@Table(name = "new_student") // 카멜로 찾는 걸로 설정해놓아서 테이블명에 언더바가 붙어있을 때 꼭 추가(_가 없는 테이블명이면 생략가능)
@Entity(name = "new_student")	// 이 클래스는 Entity다
public class StudentEntity {
	@Id	// pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto increment
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber") // 카멜케이스 필드인 경우 반드시 명시
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // createdAt이 null이면 현재 시간으로 자동으로 입력
	@Column(name = "createdAt", updatable = false) //updatable = false 추후 업데이트 시 시간 갱신 안 함
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
