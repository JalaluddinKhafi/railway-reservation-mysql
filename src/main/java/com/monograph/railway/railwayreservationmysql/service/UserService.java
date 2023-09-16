package com.monograph.railway.railwayreservationmysql.service;

import com.monograph.railway.railwayreservationmysql.model.User;
import com.monograph.railway.railwayreservationmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
