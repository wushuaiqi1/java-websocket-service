package com.ws.aop;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class LogAspect {

    @Around("@within(com.ws.annotation.LogExecutionTime)")
    public Object LogExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Signature signature = joinPoint.getSignature();

        String isCalled = String.format("%s#%s", signature.getDeclaringType(), signature.getName());
        log.info("执行方法：{}()", isCalled);
        // 执行函数
        Object proceed = joinPoint.proceed();

        stopWatch.stop();

        log.info("方法执行完成：{}()，执行耗时：{}ms", isCalled, stopWatch.getTime());

        return proceed;
    }
}
