package com.marjina.schimb_valutar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.marjina.schimb_valutar.common.persistence.models")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
