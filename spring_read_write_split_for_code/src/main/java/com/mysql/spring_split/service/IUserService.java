package com.mysql.spring_split.service;

import com.mysql.spring_split.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User createUser();

    User saveUser(User user);
}
