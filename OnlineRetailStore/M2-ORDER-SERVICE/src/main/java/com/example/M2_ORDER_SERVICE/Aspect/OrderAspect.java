package com.example.M2_ORDER_SERVICE.Aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.M2_ORDER_SERVICE.Entity.Order;

@Aspect
@Component
public class OrderAspect {
    private static final Logger logger = LoggerFactory.getLogger(OrderAspect.class);

    @Before("execution(* com.example.M2_ORDER_SERVICE.Controller.*.*(..))")
    public void beforeadvice(JoinPoint joinpoint) {
        System.out.println("..........started execution of {ordercontroller} at {}"+ joinpoint.getSignature()+"  " +new Date());
    }

    @After("execution(* com.example.M2_ORDER_SERVICE.Controller.*.*(..))")
    public void afteradvice(JoinPoint joinpoint) {
        System.out.println(".......Completed execution of {ordercontroller} at {}"+ joinpoint.getSignature()+"  " +new Date());
    }
    
    @Before("execution(* com.example.M2_ORDER_SERVICE.Service.*.*(..))")
    public void beforeserviceadvice(JoinPoint joinpoint) {
        System.out.println("..............started execution of {orderservice} at {}"+ joinpoint.getSignature()+"  " +new Date());
    }

    @After("execution(* com.example.M2_ORDER_SERVICE.Service.*.*(..))")
    public void afterserviceadvice(JoinPoint joinpoint) {
        System.out.println("..........Completed execution of {orderservice} at {}"+ joinpoint.getSignature()+"  " +new Date());
    }
    
    
    @Around("execution(* com.example.M2_ORDER_SERVICE.Controller.*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        System.out.println("Started execution of {} at {}"+ joinPoint.getSignature()+ new Date());

        // Proceed with the original method execution
        Object result = joinPoint.proceed();
        
        // Modify return value if it's an Order object
       /* if (result instanceof Order) {
            Order order = (Order) result;
            order.setStatus("Modified by AOP");
            logger.info("Modified return value of {} to {}", joinPoint.getSignature(), order.getStatus());
        }*/

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Completed execution of {} at {}. Execution time: {} ms"+ joinPoint.getSignature()+"  time: " +new Date()+ "exicutiontime : "+ executionTime);

        return result; // Return the method’s original result
    }
    
    
}

