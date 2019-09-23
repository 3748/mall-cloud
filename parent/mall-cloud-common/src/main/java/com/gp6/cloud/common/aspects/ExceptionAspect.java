package com.gp6.cloud.common.aspects;

import com.gp6.cloud.common.exceptions.MallException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 异常切面
 *
 * @author gp6
 * @date 2019/09/23
 */
@Aspect
@Component
@Slf4j
public class ExceptionAspect {

    /**
     * 环绕切面
     *
     * @param proceedingJoinPoint ProceedingJoinPoint
     * @return Object
     */
    @Around("execution(public * com.gp6.cloud.impl..*(..)))")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕前增强");
        try {
            proceedingJoinPoint.proceed();
        } catch (MallException mallException) {
            System.out.println("1111");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕后增强");
        return null;
    }
}
