package com.Jaziel.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.jetbrains.annotations.NotNull;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

/**
 * @author 王杰
 * @time 2020/9/30 19:48
 */
public class MyRespect {
    public void before(){
        System.out.println("前置增强。。。。");
    }

    public void afterReturning(){
        System.out.println("后置增强。。。。");
    }

    public Object aroud(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前增强。。。");
        Object b = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强。。。");
        return b;
    }

    public void Throwing(){
        System.out.println("异常抛出增强。。。。");
    }

    public void after(){
        System.out.println("最终抛出增强。。。。");
    }
}
