package com.proxy.controller;

import com.proxy.service.IUserService;
import com.proxy.staticproxy.IProxy;
import com.proxy.staticproxy.ProxyImpl;
import com.proxy.staticproxy.StaticProxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@Api(tags="用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("静态代理方式")
    @GetMapping("/get")
    public Object get(){
        // 被代理的类
        IProxy proxy = new ProxyImpl();
        // 代理类
        StaticProxy staticProxy = new StaticProxy(proxy);
        // 执行代理方法
        staticProxy.print();
        return "静态代理实现成功，请注意控制台的输出";
    }
}
