package com.n1b3lung0.order;

import org.springframework.boot.SpringApplication;

public class TestOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
