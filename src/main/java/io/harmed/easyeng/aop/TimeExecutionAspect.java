package io.harmed.easyeng.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class TimeExecutionAspect {

    @Pointcut("within(io.harmed.easyeng.controller.*) || " +
              "within(io.harmed.easyeng.service.impl.*)")
    public void serviceClassMethods() {
    }

    @Around("serviceClassMethods()")
    public Object logBeforeAndAfterMethod(final ProceedingJoinPoint pjp) throws Throwable {
        final Instant start = Instant.now();
        final Object proxy = pjp.proceed();
        final Instant end = Instant.now();

        log.debug("Execution of class: {}, method: {} took {} ms",
                pjp.getTarget().getClass().getSimpleName(),
                pjp.getSignature().getName(),
                Duration.between(start, end).toMillis());

        return proxy;
    }
}