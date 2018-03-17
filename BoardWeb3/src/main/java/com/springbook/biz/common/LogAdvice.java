package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Before("PointCommon.allPointCut()")
	public void printLog(JoinPoint jp) {
		System.out.println("[공통 로그] 비즈니스로직 수행 전 동작");
	}
	
	@After("PointCommon.getPointCut()")
	public void printGetLog(JoinPoint jp) {
		System.out.println("[공통 로그] get 로직 "+jp.getSignature().getName()+"수행 후 동작");
	}
}
