package com.ma.doublecolor;

import com.ma.doublecolor.config.Config_1;
import com.ma.doublecolor.service.Test1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoubleColorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoubleColorApplication.class, args);
		Test1 test1 = new Test1();
		test1.getUrl();

	}

}
