package com.proxy.controller;

import com.proxy.cglibproxy.CglibProxy;
import com.proxy.cglibproxy.ProxyClass;
import com.proxy.common.IProxy;
import com.proxy.common.ProxyImpl;
import com.proxy.jdkproxy.JdkProxy;
import com.proxy.staticproxy.StaticProxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;


@Api(tags="代理")
@RestController
@RequestMapping("/proxy")
@Slf4j
public class ProxyController {

    /**
     * 输出结果：
     *
     * 静态代理模式：本条日志在被代理方法执行前
     * 执行被代理的方法
     * 静态代理模式：本条日志在被代理方法执行后
     */
    @ApiOperation("静态代理方式")
    @GetMapping("/static")
    public Object staticProxy(){
        // 被代理的类
        IProxy proxy = new ProxyImpl();
        // 代理类
        StaticProxy staticProxy = new StaticProxy(proxy);
        // 执行代理方法
        staticProxy.print();
        return "静态代理实现成功，请注意控制台的输出";
    }


    /**
     * 输出结果：
     *
     * 目标对象的class：class com.proxy.common.ProxyImpl
     * JDK动态代理生成的代理对象的class：class com.sun.proxy.$Proxy85
     * JDK动态代理：本条日志在被代理方法执行前
     * 执行被代理的方法
     * JDK动态代理：本条日志在被代理方法执行后
     */
    @ApiOperation("JDK动态代理方式")
    @GetMapping("/jdk")
    public Object jdkProxy(){
        // 被代理的类
        ProxyImpl target = new ProxyImpl();
        log.info("目标对象的class：{}", target.getClass());

        // 初始化代理类
        JdkProxy jdkProxy = new JdkProxy(target);
        // 根据目标对象生成代理对象proxyInstance
        IProxy proxyInstance = (IProxy) jdkProxy.getProxyInstance();
        log.info("JDK动态代理生成的代理对象的class：{}", proxyInstance.getClass());

        // 调用代理对象的方法
        proxyInstance.print();

        return "JDK动态代理实现成功，请注意控制台的输出";
    }


    /**
     * 输出结果：
     *
     * 目标对象的class：class com.proxy.cglibproxy.ProxyClass
     * cglib生成的代理对象的class：class com.proxy.cglibproxy.ProxyClass$$EnhancerByCGLIB$$3a741a8e
     * cglib动态代理：本条日志在被代理方法执行前
     * 执行被代理的方法
     * cglib动态代理：本条日志在被代理方法执行后
     */
    @ApiOperation("cglib动态代理方式")
    @GetMapping("/cglib")
    public Object cglibProxy(){
        //目标对象
        ProxyClass target = new ProxyClass();
        log.info("目标对象的class：{}", target.getClass());

        //代理对象
        ProxyClass proxyInstance = (ProxyClass) new CglibProxy(target).getProxyInstance();
        log.info("cglib生成的代理对象的class：{}", proxyInstance.getClass());

        //执行代理对象方法
        proxyInstance.print();

        return "cglib动态代理实现成功，请注意控制台的输出";
    }
}
