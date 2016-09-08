package org.spytest.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class OtherAspect {

    @Around("execution(public * *(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Should not execute");
        return joinPoint.proceed();
    }
}
