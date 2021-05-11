package com.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyImpl implements IProxy {
    @Override
    public void print() {
        log.info("执行被代理的方法");
    }
}
