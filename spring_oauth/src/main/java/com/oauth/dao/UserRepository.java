package com.oauth.dao;

import com.oauth.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findFirstByUsernameAndPassword(String username, String password);

    Optional<User> findFirstByUsername(String username);
}
