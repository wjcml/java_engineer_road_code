package com.mysql.spring_split.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.mysql.spring_split.common.DataSourceKey;
import com.mysql.spring_split.common.TargetDataSource;
import com.mysql.spring_split.dao.UserRepository;
import com.mysql.spring_split.entity.User;
import com.mysql.spring_split.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @TargetDataSource(value = DataSourceKey.SLAVE)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 需要注意的是aop无法代理内部调用的方法，所以createUser()方法不能直接调用saveUser()方法，否则@TargetDataSource注解不生效
     */
    @Override
    public User createUser() {
        // 用户名使用一个随机字符串代替
        return new User(IdUtil.randomUUID(), "123456", "13535678907");
    }

    @Override
    @TargetDataSource(value = DataSourceKey.MASTER)
    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
