package groom.dashboardpractice.crud.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DashboardAspect {

    @Around("execution(* groom.dashboardpractice.crud..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[log] {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    /**
     * 트랜잭션 수행 시 로그 띄워져야 함.
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* groom.dashboardpractice.crud..service..*(..))")
    public Object logCall(ProceedingJoinPoint joinPoint) throws Throwable {
        boolean txActiveBefore = org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive();
        log.info("[before] txActive={} sig={}", txActiveBefore, joinPoint.getSignature());
        try {
            Object ret = joinPoint.proceed();
            boolean txActiveAfter = org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive();
            log.info("[afterReturning] txActive={} sig={} ret={}", txActiveAfter, joinPoint.getSignature(), ret);
            return ret;
        } catch (Throwable t) {
            log.info("[afterThrowing] txActive={} sig={} ex={}",
                    org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive(),
                    joinPoint.getSignature(), t.toString());
            throw t;
        }
    }
}
