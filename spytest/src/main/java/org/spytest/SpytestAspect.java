package org.spytest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class SpytestAspect {

    @Around("execution(public * *(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        try {
            System.out.println("Before: " + method.getName());
            return joinPoint.proceed();
        } finally {
            System.out.println("End: " + method.getName());
        }
    }
}
