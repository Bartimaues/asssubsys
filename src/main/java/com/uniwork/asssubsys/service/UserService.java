package com.uniwork.asssubsys.service;


import com.uniwork.asssubsys.dto.UserDto;
import com.uniwork.asssubsys.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}