package com.example.lesson01;

// 일반 java bean
public class Data {
	// field
	private int id;
	private String name;

	// getter, setter
	// 우클릭 - source - generate getters and
	// setters - getter setter만들 필드들 클릭 후 형성
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
