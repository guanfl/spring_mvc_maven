package com.spring.mvc.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

//单一职能
@Aspect
@Order(1)
public class MyAspect implements Ordered {
    //设置切面优先级
    private int order = 1;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    // 定义一个切入点 多个表达式
    @Pointcut("execution(* com.package.service.*(..)) || execution(* com.package.web.*(..))")
    private void pointCut() {
    }

    // 匹配点方法执行之前 执行
    @Before("pointCut() && args(name)")
    public void before(String name) {
        System.out.println(name);
        System.out.println("前置通知");
    }

    // 匹配的方法返回的时候 执行
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("后置通知");
    }

    // 最终执行 （正常返回以及异常）用于释放资源
    @After("pointCut()")
    public void after() {
        System.out.println("最终通知");
    }

    // 异常抛出后执行
    @AfterThrowing("pointCut()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }

    // 环绕通知 方法执行之前和之后执行
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("方法执行之前");
        Object object = pjp.proceed();// 执行该方法
        System.out.println("方法执行之后");
        return object;
    }
}