package com.nishubin.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(value ="com.nishubin.work")
@MapperScan(basePackages={"com.nishubin.work.dao.**"})
public class WorkAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkAdminApplication.class, args);
	}
}
