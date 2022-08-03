package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class AlphaAspect {
    //*代表方法的返回值，什么样类型的返回值都可以，service包下的所有类下的所有方法，(..)所有的参数
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointcut() {
    }
    //前面记日志
    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }
    //后面记日志
    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    //在有了返回值以后
    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    //抛出异常之后
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pj) throws Throwable{
        System.out.println("around before");
        Object object = pj.proceed();
        System.out.println("around after");
        return object;
    }

}
