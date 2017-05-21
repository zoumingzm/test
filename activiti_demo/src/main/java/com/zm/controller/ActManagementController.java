package com.zm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zm.vo.ApiResult;

@RestController
@RequestMapping("/act/process")
public class ActManagementController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@RequestMapping("/{businessKey}")
	public ApiResult startProcess(@PathVariable String businessKey){
		
			Lock lock = new ReentrantLock(true);
			
			try {
				if (lock.tryLock(2, TimeUnit.SECONDS)) {
					boolean isCreated = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(businessKey).count() > 0;
					if(isCreated){
						return ApiResult.success(businessKey + " has been created. pls check.");
					}
					ProcessInstance p = runtimeService.startProcessInstanceByKey("PrintProcess", businessKey, new ConcurrentHashMap<>());
					return ApiResult.success(p.getId());
				}else {
					return ApiResult.success(businessKey + " is locked. pls wait.");
				}
			} catch (Exception e) {
				return ApiResult.success(businessKey + " start error.");
			}finally {
				lock.unlock();
			}
		}
	
	@RequestMapping(value = "/notify/{businessKey}", method = RequestMethod.PUT)
	public ApiResult notify(@PathVariable String businessKey){
		List<ProcessInstance> pList = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(businessKey).list();

		pList.stream().forEach(p -> runtimeService.signal(p.getId()));
		return ApiResult.success("success");
	}
	
	@RequestMapping( value = "/processInstances/{businessKey}" , method = RequestMethod.GET)
	public ApiResult queryProcessInstances(@PathVariable String businessKey){
		List<ProcessInstance> pList = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(businessKey).list();
		
		return ApiResult.success(pList.stream().map(p -> p.getId()).collect(Collectors.toList()));
	}
}
