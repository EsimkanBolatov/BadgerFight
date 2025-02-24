package com.iptgroup.BadgerFight;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan("com.iptgroup.BadgerFight")
class BadgerFightApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(BadgerFightApplicationTests.class, args);
	}


}
