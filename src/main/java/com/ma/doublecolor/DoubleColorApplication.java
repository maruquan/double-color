package com.ma.doublecolor;

import com.ma.doublecolor.service.BlueBoll;
import com.ma.doublecolor.service.RedBoll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class DoubleColorApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SpringApplication.run(DoubleColorApplication.class, args);

        RedBoll redBoll = new RedBoll();
        redBoll.getRedKillBolls();
        System.out.println("--------------------------'\n'");

        BlueBoll blueBollRandom = new BlueBoll();
        blueBollRandom.getBlueKillBolls();
    }
}
