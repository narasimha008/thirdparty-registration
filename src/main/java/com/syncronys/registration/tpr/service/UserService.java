package com.syncronys.registration.tpr.service;

import com.syncronys.registration.tpr.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    abstract UserDto findByUserName(String userName);

    List<UserDto> findAllUsers();

    void updateUser(UserDto userDto);
}
