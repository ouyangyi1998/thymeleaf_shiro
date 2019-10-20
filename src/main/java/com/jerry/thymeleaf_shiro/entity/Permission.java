package com.jerry.thymeleaf_shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Permission implements Serializable {
    private Long id;
    private String permission; /*权限标识*/
    private String description;
    private Boolean available=Boolean.FALSE;/*是否可用*/

    public Permission(String permission, String description, Boolean available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }
}
