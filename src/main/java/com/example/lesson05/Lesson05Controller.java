package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// 1) List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("바나나");
		fruits.add("멜론");
		fruits.add("포도");
		fruits.add("딸기");
		model.addAttribute("fruits", fruits);
		
		// 2) List<Map> (엉뚱한 값이 들어갈 수 있어 DB에서는 map 잘 안 쓴다.)
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "김바다");
		user.put("age", 25);
		user.put("hobby", "독서");
		users.add(user);
		
		user = new HashMap<>();
		user.put("name", "신포도");
		user.put("age", 34);
		user.put("hobby", "사냥");
		users.add(user);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
	@GetMapping("/ex03")
	// model은 jsp에서 데이터를 쓸 수 있도록 담아둔다.
	public String ex03(Model model) {
		Date now = new Date();
		model.addAttribute("today", now);
		
		// ~lesson05/ex03.jsp를 리턴해 들어간다.
		return "lesson05/ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
}
