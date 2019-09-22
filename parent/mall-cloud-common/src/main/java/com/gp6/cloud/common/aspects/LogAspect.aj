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

@Aspect
@Component
@Slf4j
public class LogAspect {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 申明一个切点 里面是 execution表达式
     */
    @Pointcut("execution(public * com.gp6.cloud.impl.TestApiImpl.test())")
    private void apiImplAspect() {

    }

    /**
     * 请求method前打印内容
     *
     * @param joinPoint JoinPoint
     */
    @Before(value = "apiImplAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = null;
        if (requestAttributes != null) {
            request = requestAttributes.getRequest();
        }
        log.info("===============请求内容START===============");
        try {
            // 打印请求内容
            if (request != null) {
                log.info("请求地址:" + request.getRequestURL().toString());
                log.info("请求方式:" + request.getMethod());
            }
            log.info("请求类方法:" + joinPoint.getSignature());
            log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
        }
        log.info("===============请求内容END===============");
    }

    /**
     * 在方法执行完结后打印返回内容
     *
     * @param o 返回结果
     */
    @AfterReturning(returning = "o", value = "apiImplAspect()")
    public void methodAfterReturn(Object o) {
        log.info("--------------返回内容START----------------");
        try {
            log.info("Response内容:" + OBJECT_MAPPER.writeValueAsString(o));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodAfterReturn() ### ERROR:", e);
        }
        log.info("--------------返回内容END----------------");
    }
}
