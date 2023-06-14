package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service	// Spring Bean
public class UsedGoodsBO {
	// controller가 UsedGoods 다 주라고 함 조건없으므로 input도 없음
	
	// input: X		컨트롤러가
	// output: List<UsedGoods>	컨트롤러한테
	
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = ;
		return usedGoodsList;
	}
}
