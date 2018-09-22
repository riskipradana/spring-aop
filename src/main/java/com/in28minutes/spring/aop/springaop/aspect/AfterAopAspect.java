package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * AfterReturning : Called when a method is called successfully
     * AfterThrowing : Called when a method throws an exception
     * After        : Called in both these scenarios
     */

    @AfterReturning(
            value = "com.in28minutes.spring.aop.springaop.aspect.CommonJointPointConfig.businessLayerExecution()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){
        LOGGER.info("{} returned with value {}", joinPoint, result);
    }

    @After(value = "com.in28minutes.spring.aop.springaop.aspect.CommonJointPointConfig.businessLayerExecution()")
    public void after(JoinPoint joinPoint){
        LOGGER.info("after execution of {}", joinPoint);
    }
}
