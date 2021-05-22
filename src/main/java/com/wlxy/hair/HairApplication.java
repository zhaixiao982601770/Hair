package com.wlxy.hair;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@MapperScan("com.wlxy.hair.dao")
@SpringBootApplication
public class HairApplication {


    @Value("{spring.profiles.active}")
    private String info;

    public static void main(String[] args) {
        SpringApplication.run(HairApplication.class, args);
    }

}
