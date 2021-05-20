package com.log.spring_log.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Api(value = "日志管理", tags = "日志管理")
@Slf4j
public class LogController {
    @GetMapping("/get")
    @ApiOperation(value = "日志接口")
    public String get(){
        log.debug("debug级别的日志");
        log.debug("debug级别的日志");
        log.debug("debug级别的日志");
        log.debug("debug级别的日志");
        log.debug("debug级别的日志");
        log.debug("debug级别的日志");

        log.info("info级别的日志");
        log.info("info级别的日志");
        log.info("info级别的日志");
        log.info("info级别的日志");
        log.info("info级别的日志");
        log.info("info级别的日志");

        log.warn("warn级别的日志");
        log.warn("warn级别的日志");
        log.warn("warn级别的日志");
        log.warn("warn级别的日志");
        log.warn("warn级别的日志");
        log.warn("warn级别的日志");

        log.error("error级别的日志");
        log.error("error级别的日志");
        log.error("error级别的日志");
        log.error("error级别的日志");
        log.error("error级别的日志");
        log.error("error级别的日志");

        return "执行成功，注意日志打印";
    }
}
