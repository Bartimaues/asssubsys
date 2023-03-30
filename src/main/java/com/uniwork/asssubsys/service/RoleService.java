package com.uniwork.asssubsys.service;

import java.util.List;

import com.uniwork.asssubsys.dto.RoleDto;


public interface RoleService {
    List<RoleDto> getAllRoles();
    RoleDto getRoleById(Long id);
    RoleDto saveRole(RoleDto roleDto);
    void deleteRole(Long id);
}
