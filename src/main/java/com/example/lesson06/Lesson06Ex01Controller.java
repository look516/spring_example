package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 페이지(view)
	@GetMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	// AJAX가 요청한 곳 => response String(data)이어야 함
	@PostMapping("/add_user")
	@ResponseBody	// String data를 응답으로 주어야 함
	public String addUser(
			@RequestParam("name") String name, // data의 키명과 requestparam명이 일치해야 함
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// db insert (앞 부분 점검 먼저하고 맨 마지막에 해보자)
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// return string
		return "성공"; // break point걸고 확인
		
	}
	
	// 입력 성공 페이지(view)
	@GetMapping("/after_add_user_view")
	public String afterAddUserView() { // view page의 경로 리턴
		return "lesson06/afterAddUser";
	}
}
