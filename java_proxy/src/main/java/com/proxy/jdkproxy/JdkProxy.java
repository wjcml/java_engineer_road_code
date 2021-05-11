package com.proxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 动态代理，通过反射的方式实现的代理
 * JDK动态代理的核心是InvocationHandler接口和Proxy类
 *
 * 动态代理对象不需要实现接口，但是要求 目标对象 必须实现接口，否则不能使用动态代理
 */
@Slf4j
public class JdkProxy implements InvocationHandler {

    private final Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    /**
     *  invoke()方法在代理实例上处理方法调用并返回结果。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("JDK动态代理：本条日志在被代理方法执行前, before-------切面加入逻辑");
        //通过反射执行，目标类的方法
        Object invoke = method.invoke(target, args);
        log.info("JDK动态代理：本条日志在被代理方法执行后, after-------切面加入逻辑");
        return invoke;
    }

    /**
     * 获取目标对象的代理对象
     * Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例,
     * Proxy.newProxyInstance()方法返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
     * 这里返回的对象就是我们目标类的增强代理类
     * @return 代理对象
     */
    public Object getProxyObject() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}
