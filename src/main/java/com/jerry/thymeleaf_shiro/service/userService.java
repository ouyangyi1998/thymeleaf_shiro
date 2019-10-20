package com.jerry.thymeleaf_shiro.service;

import com.jerry.thymeleaf_shiro.entity.User;

import java.util.List;
import java.util.Set;

public interface userService {
    public Long createUser(User user);
    public void changePassword(Long userId,String newPassword);
    public void correlationRoles(Long userId,Long...roleIds);
    public void uncorrelationRoles(Long userId,Long...roleIds);
    public void deleteUser(Long id);
    public User findById(long Id);
    public User findByUsername(String username);
    public Set<String> findRoles(String username);
    public Set<String> findPermissions(String username);
    public List<User> findAll();
    public void deleteUser_Role(Long id);
}
