package dev.spring.transactions.aop;

import dev.spring.transactions.config.TransactionConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Slf4j
@Component
public class TransactionAspect {

    private TransactionConfig config;

    public TransactionAspect(TransactionConfig config) {
        this.config = config;
    }

    @Pointcut("execution(* dev.spring.transactions.service.*.*(..))")
    public void allServiceMethods() {
    }

    @Before("allServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        logMethodDetails(true, joinPoint, null);
    }

    @AfterReturning(pointcut = "allServiceMethods()", returning = "value")
    public void logReturn(JoinPoint joinPoint, Object value) {
        logMethodDetails(false, joinPoint, value);
    }

    @AfterThrowing(pointcut = "allServiceMethods()", throwing = "ex")
    public void logException(Exception ex) {
        log.error("Exception message: {}", ex.getMessage());
    }

    private void logMethodDetails(boolean isBefore, JoinPoint joinPoint, Object returnValue) {
        if (!config.isDebugModeEnabled()) return;
        StringBuilder message = new StringBuilder();
        message.append(String.format("Method: '%s'. ", LocalDateTime.now(), joinPoint.getSignature().getName()));

        if (isBefore) {
            Object[] args = joinPoint.getArgs();
            if (args.length > 0) message.append("Params: ").append(Arrays.toString(args));
        }

        if (returnValue != null) message.append(", Returned value: ").append(returnValue);
        log.info(message.toString());
    }
}
