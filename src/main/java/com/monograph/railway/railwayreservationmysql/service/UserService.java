package com.monograph.railway.railwayreservationmysql.service;

import com.monograph.railway.railwayreservationmysql.model.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    @Transactional
    void deleteUser(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    public int getTotalUserCount();

}
