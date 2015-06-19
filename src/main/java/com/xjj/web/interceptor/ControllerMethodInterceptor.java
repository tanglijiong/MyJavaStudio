package com.xjj.web.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjj.annotation.LoginNotRequired;

/**
 * 方法拦截器，拦截Controller中的方法，记录log
 * @author XuJijun
 *
 */
public class ControllerMethodInterceptor implements MethodInterceptor {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final static ObjectMapper jsonMapper = new ObjectMapper();

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		
		if(method.isAnnotationPresent(LoginNotRequired.class)){
			logger.info("我不需要登录！");
		}
		
		logger.info("Before: interceptor name: {}", invocation.getMethod().getName());
		
		logger.info("Arguments: {}", jsonMapper.writeValueAsString(invocation.getArguments()));
		
		Object result = invocation.proceed();
		
		logger.info("After: result: {}", jsonMapper.writeValueAsString(result));
		
		return result;
	}

}
