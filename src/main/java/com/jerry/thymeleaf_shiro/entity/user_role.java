package com.jerry.thymeleaf_shiro.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class user_role implements Serializable {
    private Long userId;
    private Long roleId;

}
