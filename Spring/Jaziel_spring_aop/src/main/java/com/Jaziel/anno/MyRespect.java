package com.Jaziel.anno;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author 王杰
 * @time 2020/9/30 19:48
 */
@Component("myRespect")
// 注明当前 MyRespect 是一个切面
@Aspect
public class MyRespect {
    // 前置增强
    @Before("execution(* com.Jaziel.anno.*.*(..))")
    public void before(){
    System.out.println("前置增强。。。。");
    }

    public void afterReturning(){
    System.out.println("后置增强。。。。");
    }

    //环绕表达式
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前这鞥强");
        Object b = proceedingJoinPoint.proceed();
        System.out.println("环绕后这鞥强");
        return b;
    }

    public void Throwing(){
    System.out.println("异常抛出增强。。。。");
    }

    // 最红增强
    @After("MyRespect.pointcut()")
    public void after(){
    System.out.println("最终抛出增强。。。。");
    }

    // 抽取切点表达式
    @Pointcut("execution(* com.Jaziel.anno.*.*(..))")
    public void pointcut(){

    }
}
