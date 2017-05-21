package com.zm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zm.vo.ApiResult;

@RestController
public class HealthCheck {
	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ApiResult health(){
		return ApiResult.success("success");
	}
}
