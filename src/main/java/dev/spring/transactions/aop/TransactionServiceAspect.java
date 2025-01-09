package dev.spring.transactions.aop;

import dev.spring.transactions.config.TransactionConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
@ConditionalOnProperty(prefix = "transactions", value = "debugModeEnabled", havingValue = "true", matchIfMissing = false)
public class TransactionServiceAspect {

    private TransactionConfig config;

    public TransactionServiceAspect(TransactionConfig config) {
        this.config = config;
    }

    private static final String POINTCUT_EXEC_FOR_ALL_SERVICE_METHODS = "execution(* dev.spring.transactions.service.*.*(..))";

/*    @Pointcut("execution(* dev.spring.transactions.service.*.*(..))")
    public void allServiceMethods() {
    }*/

    @Before(POINTCUT_EXEC_FOR_ALL_SERVICE_METHODS)
    public void logBefore(JoinPoint joinPoint) {
        logMethodDetails(true, joinPoint, null);
    }

    @AfterReturning(pointcut = POINTCUT_EXEC_FOR_ALL_SERVICE_METHODS, returning = "value")
    public void logReturn(JoinPoint joinPoint, Object value) {
        logMethodDetails(false, joinPoint, value);
    }

    @AfterThrowing(pointcut = POINTCUT_EXEC_FOR_ALL_SERVICE_METHODS, throwing = "ex")
    public void logException(Exception ex) {
        log.error("Exception message: {}", ex.getMessage());
    }

    private void logMethodDetails(boolean isBefore, JoinPoint joinPoint, Object returnValue) {
        StringBuilder message = new StringBuilder();
        message.append(String.format("Method: '%s'", joinPoint.getSignature().getName()));

        if (isBefore) message.append(" Called :: Params: ").append(Arrays.toString(joinPoint.getArgs()));
        else message.append(" Executed :: Returned value: ").append(returnValue);
        log.debug(message.toString());
    }
}