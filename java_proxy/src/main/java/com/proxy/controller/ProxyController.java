package com.proxy.controller;

import com.proxy.common.IProxy;
import com.proxy.common.ProxyImpl;
import com.proxy.jdkproxy.JdkProxy;
import com.proxy.staticproxy.StaticProxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;


@Api(tags="用户管理")
@RestController
@RequestMapping("/proxy")
public class ProxyController {

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

    @ApiOperation("JDK动态代理方式")
    @GetMapping("/jdk")
    public Object jdkProxy(){
        // 被代理的类
        ProxyImpl proxyImpl = new ProxyImpl();
        // 代理类
        JdkProxy jdkProxy = new JdkProxy(proxyImpl);

        // 根据目标对象生成代理对象
        IProxy proxyInstance = (IProxy) jdkProxy.getProxyObject();
        // 调用代理对象的方法
        proxyInstance.print();

        return "JDK动态代理实现成功，请注意控制台的输出";
    }
}
