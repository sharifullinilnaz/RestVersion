package ru.itis.rest.service;

import ru.itis.rest.dto.SignInDto;
import ru.itis.rest.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInDto);
}
