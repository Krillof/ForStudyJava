package com.mimimetr.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findByNameAndPassword(String name, String password);
    List<User> findByName(String name);
}
