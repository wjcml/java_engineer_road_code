package com.log.spring_log.util;

import java.util.Properties;

public class ElkPropsUtil {
    public ElkPropsUtil() {
    }

    /**获取elk的日志地址配置，默认为空*/
    public static String getDestination() {
        Properties props = System.getProperties();
        return props.getProperty("log.elk.destination", "");
    }
}
