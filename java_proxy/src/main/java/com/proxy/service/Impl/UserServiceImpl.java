package com.proxy.service.Impl;

import com.proxy.entity.User;
import com.proxy.entity.UserVo;
import com.proxy.dao.UserRepository;
import com.proxy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserVo getOne() {
        return null;
    }
}
