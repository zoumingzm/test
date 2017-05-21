package com.zm.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("printTask")
public class PrintTask implements JavaDelegate{

	public static final Logger logger = LoggerFactory.getLogger(PrintTask.class);
	
	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		logger.info(arg0.getProcessBusinessKey());
	}

	
}
