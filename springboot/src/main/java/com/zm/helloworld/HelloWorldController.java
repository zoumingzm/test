package com.zm.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Administrator on 2017/3/6.
 */

@RestController
public class HelloWorldController {

    @RequestMapping("/index")
    public String index(){
        return "hello world!";
    }

    public static void main(String[] args){
        SpringApplication.run(HelloWorldController.class,args);
    }
}
