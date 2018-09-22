package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Aspect is combination of Pointcut and Advice
 */

@Aspect
@Configuration
public class UserAccessAspect {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * Pointcut (what kind method calls i would intercept)
     * execution(* PACKAGE.*.*(..))
     *
     * Advice (what to do after intercept the method)
     *
     * JointPoint (specific method which want to intercepted)
     *
     * why use aspect?
     * this is defining in one place and applicable in all methods in package which defining
     * (int this case is business package)
     *
     * Weaving (is aspect/AOP implemented in the right moment)
     * Weaver(framework to do weaving)
     */

    @Before("com.in28minutes.spring.aop.springaop.aspect.CommonJointPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint){
        //Advice
        LOGGER.info("Check for user access");
        LOGGER.info("Allowed execution for {}", joinPoint);
    }
}
