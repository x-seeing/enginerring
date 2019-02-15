package com.see.enginerring.efrost.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 邵爱双 04
 * Created by suyaqiang (sueeing@126.com) on 2019/1/20.
 */
@SpringBootApplication
public class EfrostApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EfrostApplication.class).run(args);
    }

}
