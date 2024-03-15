package com.casarol.webservice;

import com.sun.jdi.request.InvalidRequestStateException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TokenValidation {

    @Before("@annotation(ValidateToken)")
    public void validation(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("Args length: " + joinPoint.getArgs().length);
        for(Object obj: joinPoint.getArgs()) {
            System.out.println(obj.toString());
        }
        System.out.println("JoinPoint string: " + joinPoint.getArgs()[0].toString());
        String token = (String) joinPoint.getArgs()[0];
        System.out.println("Parsed Token: " + token);
        if(!token.equals("token")) {
            throw new InvalidRequestStateException("Token expired!");
        }
    }
}
