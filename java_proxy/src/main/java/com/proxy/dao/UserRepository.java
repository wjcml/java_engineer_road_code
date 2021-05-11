package com.proxy.dao;

import com.proxy.entity.User;
import com.proxy.entity.UserVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<UserVo> findUserById(Integer id);
    Optional<User> findByUsername(String username);
    Optional<User> findByPhone(String phone);
}
