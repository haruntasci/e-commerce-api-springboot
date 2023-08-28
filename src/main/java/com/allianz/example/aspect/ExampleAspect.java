package com.allianz.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {

//    @Before("execution(* com.allianz.example.util.*.*(..))")
//    public void beforeMethodExecution(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("Entering method: " + methodName);
//    }

    @Around("execution(* com.allianz.example.service.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before method execution");

        Object result = proceedingJoinPoint.proceed();

        System.out.println("After method execution");

        return result;
    }

    @AfterThrowing("execution(* com.allianz.example.service.*.*(..))")
    public void throwableAdvice(){
        System.err.println("Throwable worked");
    }

    @AfterReturning("execution(* com.allianz.example.service.*.*(..))")
    public void returnAdvice(){
        System.err.println("Return worked");
    }



}
