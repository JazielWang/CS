package com.Jaziel.proxy.cglib;

import com.Jaziel.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 王杰
 * @time 2020/9/29 15:01
 */
public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target = new Target();
        //增强对象
        final Advice advice = new Advice();
        // 返回值就是动态生成的代理对象
        // 1. 创建增强器
        Enhancer enhancer = new Enhancer();
        // 2. 设置父类目标
        enhancer.setSuperclass(target.getClass());
        // 3. 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, objects);
                advice.after();
                return invoke;
            }
        });
        // 4. 创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
