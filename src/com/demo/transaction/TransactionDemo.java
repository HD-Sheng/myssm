package com.demo.transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class TransactionDemo {
	private static final Log logger = LogFactory.getLog(TransactionDemo.class);
	
	public void startTransaction() {
		logger.info("logger======================begin transaction");
	}

	public void commitTransaction() {
		logger.info("logger======================commit transaction");
	}
	
	/**
	 * 如果controller有返回值，则必须用 proceed 方法接收，否则前台无法获取
	 * @param joinPoing
	 * @return
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint joinPoing) throws Throwable {
		Object result = null;
		logger.info("begin transaction");
		result = joinPoing.proceed();
		logger.info("commit transaction");
		return result;
	}
}
