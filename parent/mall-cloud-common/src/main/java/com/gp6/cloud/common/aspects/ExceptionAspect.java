package com.gp6.cloud.common.aspects;

import com.gp6.cloud.common.enums.ResponseCodeEnum;
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
     * @return MallResponse
     */
    @Around("execution(public * com.gp6.cloud.*.impl..*(..)))")
    public MallResponse aroundAspect(ProceedingJoinPoint proceedingJoinPoint) {
        MallResponse mallResponse;
        try {
            mallResponse = (MallResponse) proceedingJoinPoint.proceed();
        } catch (MallException mallException) {
            //throw new MallException(ResponseCodeEnum.REQUEST_PARAM_ERROR);
            return MallResponse.build(mallException.getResponseCodeEnum());
        } catch (Throwable e) {
            log.error("aroundAspect,error:{}", e);
            return MallResponse.build(ResponseCodeEnum.SYSTEM_ERROR);
        }
        return mallResponse;
    }
}
