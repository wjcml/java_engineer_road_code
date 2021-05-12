package com.proxy.cglibproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyClass {
    public void print() {
        log.info("执行被代理的方法");
    }
}
