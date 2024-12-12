package com.group2.bookstore.service;

import com.group2.bookstore.dto.request.RoleRequest;
import com.group2.bookstore.dto.response.RoleResponse;

import java.util.List;

public interface RoleService  {
    RoleResponse createRole (RoleRequest roleRequest);

    RoleResponse getRoleByRoleName(String roleName);

    RoleResponse getRoleById(Long roleId);

    List<RoleResponse> getAllRole();

    String deleteRole(Long roleId);
}
