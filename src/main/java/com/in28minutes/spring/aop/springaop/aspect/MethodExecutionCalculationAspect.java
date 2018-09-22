package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Around("com.in28minutes.spring.aop.springaop.aspect.CommonJointPointConfig.trackTineAnnotation()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        //intercept the execution and do something
        long startTime =  System.currentTimeMillis();

        //continue the execution
        joinPoint.proceed();

        //do something after execution
        long timeTaken = System.currentTimeMillis() - startTime;

        LOGGER.info("Time Taken by {} is {}", joinPoint, timeTaken);
    }

}
