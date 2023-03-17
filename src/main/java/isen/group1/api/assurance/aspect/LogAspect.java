package isen.group1.api.assurance.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* isen.group1.api.assurance.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Start method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* isen.group1.api.assurance.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("End method: " + joinPoint.getSignature().getName());
    }
}