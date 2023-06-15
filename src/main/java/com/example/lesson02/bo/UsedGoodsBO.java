package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsMapper;
import com.example.lesson02.domain.UsedGoods;

@Service	// Spring Bean
public class UsedGoodsBO {
	
	// 필드
	@Autowired // Dependency Inject (DI): 의존성(객체)를 주입한다. -> null 대신 spring container에서 Spring bean을 넣어준다.
	private UsedGoodsMapper usedGoodsMapper; // null
	
	// controller가 UsedGoods 다 주라고 함 조건없으므로 input도 없음
	
	// input: X		컨트롤러가
	// output: List<UsedGoods>	컨트롤러한테
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
		return usedGoodsList;
	}
}
