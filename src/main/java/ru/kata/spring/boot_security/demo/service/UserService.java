package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findUserById(Long userId);

    User findByUsername(String username);

    List<User> allUsers();

    List<Role> allRoles();

    void saveUser(User user);

    void deleteUser(Long userId);

    void updateUser(Long id, User user);

}
