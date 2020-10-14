package com.Jaziel.proxy.jdk;

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
        // public static Object newProxyInstance(ClassLoader loader,
        //                                      Class<?>[] interfaces,
        //                                      InvocationHandler h) throws IllegalArgumentException
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                //目标对象类加载器
                target.getClass().getClassLoader(),
                //目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                //调用对象所有方法，实际执行的都是 invoke 方法
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();//前置增强
                        Object invoke = method.invoke(target, args);// 执行目标方法
                        advice.after();//后置增强
                        return invoke;
                    }
                }
        );
        proxy.save();
    }
}
