package com.mysql.spring_split.controller;


import com.mysql.spring_split.entity.User;
import com.mysql.spring_split.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(value = "用户管理", tags = "用户管理")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/get")
    @ApiOperation(value = "获取所有用户")
    public List<User> get(){
        return userService.findAll();
    }

    @GetMapping(value = "/add")
    @ApiOperation(value = "随机添加一个用户")
    public User add(){
        return userService.createUser();
    }
}
