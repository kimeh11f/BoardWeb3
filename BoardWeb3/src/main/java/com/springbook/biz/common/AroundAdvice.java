package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		System.out.println(method + "() 메소드 수행");
		Object obj = pjp.proceed();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : "
				+ stopWatch.getTotalTimeMillis() + "(ms)초");
		return obj;
	}
}
