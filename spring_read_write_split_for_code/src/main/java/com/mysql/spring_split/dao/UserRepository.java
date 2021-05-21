package com.mysql.spring_split.dao;

import com.mysql.spring_split.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserByUsername(String name);
    List<User> findAll();
}
