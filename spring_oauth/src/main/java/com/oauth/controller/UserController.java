package com.oauth.controller;

import com.common.CommonException;
import com.common.Result;
import com.oauth.entity.User;
import com.oauth.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "用户管理", tags = "用户管理")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    @ApiOperation(value = "登录接口")
    public Result<Map<String, String>> login(User user) {
        Map<String, String> map = new HashMap<>();
        map.put("token", userService.userLogin(user));
        return Result.ok(map);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增用户")
    public Result<?> add(@Valid @RequestBody User user) {
        userService.adduser(user);
        return Result.ok();
    }
}
