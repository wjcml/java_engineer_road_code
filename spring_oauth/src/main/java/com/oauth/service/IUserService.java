package com.oauth.service;

import com.oauth.entity.User;

public interface IUserService {
    String userLogin(User user);

    void adduser(User user);
}
