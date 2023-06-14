package com.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@MapperScan(basePackages = "com.example.*") // 설정을 읽어들이는 annotation (DB Repository 찾기 위한 어노테이션)
@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

	// interface로 import 해야함!!!
	// DB 정보는 application.properties에
	// @어쩌구 제거, mapperscan, Bean, application properties
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"); // mappers 패키지에 ~Mapper.xml로 끝나는
		sessionFactory.setMapperLocations(res);

		return sessionFactory.getObject();
	}

}
