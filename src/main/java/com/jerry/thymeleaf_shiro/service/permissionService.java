package com.jerry.thymeleaf_shiro.service;

import com.jerry.thymeleaf_shiro.entity.Permission;

public interface permissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
