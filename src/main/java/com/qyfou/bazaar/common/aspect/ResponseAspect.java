package com.qyfou.bazaar.common.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResponseAspect {
    @AllArgsConstructor
    @Getter
    public enum messageStatus {
        SUCCESS(0, "success"),
        ERROR(1, "error");

        private final Integer state;
        private final String message;
    }

    @Data
    public static class Response {
        private Integer status = messageStatus.SUCCESS.state;
        private String message = messageStatus.SUCCESS.message;
        private Object data;
    }

    @Around("execution(* com.qyfou.bazaar.controller.*Controller.*(..))")
    public Object amplifyResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        Response response = new Response();
        try {
            Object result = joinPoint.proceed();
            response.setData(result);
        } catch (Exception e) {
            response.setStatus(messageStatus.ERROR.state);
            response.setMessage(messageStatus.ERROR.message);
            e.printStackTrace();
        }
        return response;
    }
}