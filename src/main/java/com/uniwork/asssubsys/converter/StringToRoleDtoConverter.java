package com.uniwork.asssubsys.converter;

import java.beans.PropertyEditorSupport;

import com.uniwork.asssubsys.dto.RoleDto;

public class StringToRoleDtoConverter extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(Long.parseLong(text));
        setValue(roleDto);
    }
}
