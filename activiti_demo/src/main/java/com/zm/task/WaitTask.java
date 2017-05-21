package com.zm.task;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class WaitTask implements JavaDelegate {

	@Autowired
	private RuntimeService runtimeService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
			runtimeService.signal(execution.getId());
	}

}
