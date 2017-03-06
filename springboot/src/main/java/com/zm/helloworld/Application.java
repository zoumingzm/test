package com.zm.helloworld;

import com.zm.helloworld.HelloWorldController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created by Administrator on 2017/3/6.
 */
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args){
        SpringApplication.run(HelloWorldController.class,args);
    }
}
