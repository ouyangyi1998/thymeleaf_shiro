package com.jerry.thymeleaf_shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Role implements Serializable {
    private Long id;
    private String role;
    private String description;

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    private Boolean available=Boolean.FALSE;
}
