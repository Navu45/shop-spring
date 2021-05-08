package com.example.shopspring.aspects;

import com.example.shopspring.services.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class EmailAspect {

    @Pointcut("execution(* com.example.shopspring.services.database.*.create(..)))")
    public void createServiceMethods() {}

    @Around("createServiceMethods()")
    public Object sendEmail(ProceedingJoinPoint joinPoint) throws Throwable {
        EmailService service = new EmailService();
        Object proceed = joinPoint.proceed();
        service.sendEmailMessage(proceed);
        return proceed;
    }

    @Before("createServiceMethods()")
    public void logParameters(JoinPoint joinPoint) {
        log.info("Send Email with ", joinPoint.getArgs());
    }
}
