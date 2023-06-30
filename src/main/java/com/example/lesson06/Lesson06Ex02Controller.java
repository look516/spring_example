package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	@GetMapping("/add_name_view")
	public String addNameView() {
		return "lesson06/addName";
	}
	
	// AJAX 요청
	// 이름 중복확인
	@ResponseBody
	@RequestMapping("/is_duplication")
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		// db 조회 (lesson04의 UserBO 이용)
		// 변수로 만드는 이유 => debug해서 어디서 error인지 파악가능
		boolean existUser = userBO.existUserByName(name);
		
		// {"isDuplication":true}
		Map<String, Boolean> result = new HashMap<>();
		result.put("isDuplication", existUser);
		return result;
	}
}
