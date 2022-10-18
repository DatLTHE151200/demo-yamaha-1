package com.example.demoyamaha1.service;

import com.example.demoyamaha1.entity.Role;

public interface RoleService extends BaseService<Role>{
    Role findRoleByName(String name);
}
