package org.springboot.users.service;

import java.util.List;
import java.util.Optional;

import org.springboot.users.entity.userEntity;

public interface userService {
     List<userEntity> findAll();
     Optional<userEntity> findById(Integer id);
     void saveUser(userEntity userEntity);
     void deleteUser(Integer id);
     List<userEntity> search(String term);
}
