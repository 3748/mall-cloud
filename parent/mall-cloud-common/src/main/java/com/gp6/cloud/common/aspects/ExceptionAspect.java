package com.gp6.cloud.common.aspects;

import com.gp6.cloud.common.exceptions.MallException;
import com.gp6.cloud.common.responses.MallResponse;
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
        try {
            proceedingJoinPoint.proceed();
        } catch (MallException mallException) {
            return MallResponse.build(mallException.getResponseCodeEnum());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
