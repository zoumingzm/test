package com.zm.helloworld;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Administrator on 2017/3/6.
 */

@RestController
public class HelloWorldController {

    @ApiOperation(value = "hello world 页面", notes = "入门第一页面。")
    @ApiImplicitParam
    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String index(){
        return "hello world!";
    }

    public static void main(String[] args){
        SpringApplication.run(HelloWorldController.class,args);
    }
}
