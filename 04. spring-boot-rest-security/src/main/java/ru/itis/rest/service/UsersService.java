package ru.itis.rest.service;

import ru.itis.rest.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    void deleteUser(Long userId);
}
