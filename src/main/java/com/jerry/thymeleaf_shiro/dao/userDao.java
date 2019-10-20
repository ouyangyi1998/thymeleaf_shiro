package com.jerry.thymeleaf_shiro.dao;

import com.jerry.thymeleaf_shiro.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface userDao {
    public Long createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public void deleteUser_Role(Long id);
    User findOne(Long userId);
    User findByUsername(String username);
    Set<String> findRoles(String username);
    Set<String> findPermissions(String username);
    List<User> findAll();
    User findById(Long id);
    public void correlationRoles(Long userId,Long... roleIds);
    public void uncorrelationRoles(Long userId,Long...roleIds);
}
