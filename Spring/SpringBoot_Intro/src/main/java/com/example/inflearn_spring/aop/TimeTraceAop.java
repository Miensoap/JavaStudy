package com.example.inflearn_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    /**
     * 핵심 관심사와 '공통 관심 사항' 분리 (시간 측정 로직)
     * 원하는 적용 대상 선택 가능 : Around
     * 프록시 사용 : 컨트롤러가 가짜 서비스 호출 -> 진짜 서비스 호출
     */
    @Around("execution(* com.example.inflearn_spring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("Start: "+joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("End: " + joinPoint.toString() +" " +timeMs +"ms");
        }
    }
}
