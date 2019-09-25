package com.gp6.cloud.common.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日至切面
 *
 * @author gp6
 * @date 2019/09/23
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 申明一个切点
     */
    @Pointcut("execution(public * com.gp6.cloud.*.impl..*(..)))")
    private void apiImplAspect() {

    }

    /**
     * 请求method前打印内容
     *
     * @param joinPoint JoinPoint
     */
    @Before(value = "apiImplAspect()")
    public void beforeAspect(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (requestAttributes != null) {
            request = requestAttributes.getRequest();
        }
        log.info("Request Start==================================");
        try {
            // 打印请求内容
            if (request != null) {
                log.info("Request Url:" + request.getRequestURL().toString());
                log.info("Method:" + request.getMethod());
            }
            log.info("Signature:" + joinPoint.getSignature());
            log.info("Param:" + Arrays.toString(joinPoint.getArgs()));
        } catch (Exception e) {
            log.error("beforeAspect,error:{}", e);
        }
        log.info("Request End==================================");
    }

    /**
     * 在方法执行完结后打印返回内容
     *
     * @param o 返回结果
     */
    @AfterReturning(returning = "o", value = "apiImplAspect()")
    public void afterAspect(Object o) {
        log.info("Response Start>>>>>>>>>>>>>>>>>>>>>");
        try {
            log.info("Response:" + OBJECT_MAPPER.writeValueAsString(o));
        } catch (Exception e) {
            log.error("afterAspect() error:{}", e);
        }
        log.info("Response End>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
