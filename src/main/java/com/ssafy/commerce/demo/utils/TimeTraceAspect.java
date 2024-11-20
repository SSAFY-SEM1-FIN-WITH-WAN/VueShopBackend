package com.ssafy.commerce.demo.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class TimeTraceAspect {

	private static final Logger log = LoggerFactory.getLogger(TimeTraceAspect.class);
	
    @Around("@annotation(com.ssafy.commerce.demo.utils.annotation.TimeTrace)")
    public Object doTrace(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTIme = System.currentTimeMillis();
        
        Object result = joinPoint.proceed();

        long endTIme = System.currentTimeMillis();

        long resultTime = endTIme - startTIme;
        String target = joinPoint.getSignature().toShortString();
        log.info("메서드 시간 측정 {} , {} ms", target, resultTime);
        return result;
    }
}


