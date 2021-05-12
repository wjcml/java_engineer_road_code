package com.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class JavaProxyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavaProxyApplication.class, args);

        Environment environment = context.getBean(Environment.class);
        System.out.println("===============================================================");
        System.out.println(String.format("swagger文档：http://localhost:%s/doc.html", environment.getProperty("server.port")));
        System.out.println("===============================================================");
    }

}
