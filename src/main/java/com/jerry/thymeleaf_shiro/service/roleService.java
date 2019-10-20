package com.jerry.thymeleaf_shiro.service;

import com.jerry.thymeleaf_shiro.entity.Role;

public interface roleService {
    public Role createRole(Role role);
    public void deleteRole(Long roleId);
    public void correlationPermissions(Long roleId,Long...permissionId);
    public void uncorrelationPermissions(Long roleId,Long...permissionId);
}
