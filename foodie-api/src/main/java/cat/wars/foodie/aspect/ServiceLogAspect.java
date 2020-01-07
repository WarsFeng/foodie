package cat.wars.foodie.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @program: foodie
 * @description: Service log around
 * @author: Wars
 * @created: 2019/12/29 00:21
 */
@Slf4j
@Aspect
@Component
public class ServiceLogAspect {

    @Around("execution(* cat.wars.foodie.service..*.*(..))")
    public Object recordExecutionTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("====== 开始执行 {}.{} ====="
                , joinPoint.getTarget().getClass()
                , joinPoint.getSignature().getName());

        long beginTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        long takeTime = endTime - beginTime;
        if (2000 >= takeTime)
            log.info("===== 执行结束，耗时：{} 毫秒", takeTime);
        else if (3000 >= takeTime)
            log.warn("===== 执行结束，耗时：{} 毫秒", takeTime);
        else log.warn("===== 执行结束，耗时：{} 毫秒", takeTime);

        return result;
    }
}
