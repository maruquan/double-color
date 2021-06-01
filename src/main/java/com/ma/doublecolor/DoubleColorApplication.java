package com.ma.doublecolor;

import com.ma.doublecolor.service.StaticMainTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class DoubleColorApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
		SpringApplication.run(DoubleColorApplication.class, args);
		StaticMainTest staticMainTest = new StaticMainTest();
		staticMainTest.startRestTemplate();


	}

}
