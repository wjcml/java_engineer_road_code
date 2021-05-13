package com.oauth.service.Impl;

import com.oauth.common.ServiceException;
import com.oauth.dao.UserRepository;
import com.oauth.entity.User;
import com.oauth.service.IUserService;
import com.oauth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String userLogin(User user) {
        Optional<User> userOptional = userRepository.findFirstByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (!userOptional.isPresent()){
            throw new ServiceException("用户名或密码错误");
        }

        return JwtUtil.createToken(userOptional.get());
    }

    @Override
    public void adduser(User user) {
        Optional<User> userOptional = userRepository.findFirstByUsername(user.getUsername());
        if (userOptional.isPresent()){
            throw new ServiceException("用户名已存在");
        }

        userRepository.save(user);
    }
}
