package com.proxy.staticproxy;

import com.proxy.common.IProxy;
import lombok.extern.slf4j.Slf4j;

/**
 * 静态代理
 */
@Slf4j
public class StaticProxy implements IProxy {
    private final IProxy proxy;

    public StaticProxy(IProxy proxy){
        this.proxy = proxy;
    }
    @Override
    public void print() {
        log.info("静态代理模式：本条日志在被代理方法执行前");
        proxy.print();
        log.info("静态代理模式：本条日志在被代理方法执行后");
    }
}
