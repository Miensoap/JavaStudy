package com.example.jpaprac.entity.user.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegistrationID {
    GOOGLE("google"),
    GITHUB("github");

    private final String name;
}
