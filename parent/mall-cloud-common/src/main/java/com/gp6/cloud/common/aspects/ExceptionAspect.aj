package com.gp6.cloud.common.aspects;

import com.gp6.cloud.common.exceptions.MallException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * java类作用描述
 *
 * @author gp6
 * @date 2019/09/20
 */
@Aspect
@Component
public aspect ExceptionAspect {

    @Around("execution(* com.gp6.cloud.api.impl..*(..)))")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕前增强");
        try {
            proceedingJoinPoint.proceed();
        } catch (MallException mallException) {
            System.out.println("1111");
        }catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕后增强");
        return null;
    }
}
