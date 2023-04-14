package com.example.jpa_lab_2.domain.entity;

import lombok.Getter;

public enum Position {
    HEAD("head"),
    EMPLOYEE("employee"),
    MANAGER("manager"),
    DEVELOPER("developer");

    @Getter
    private final String displayName;

    private Position(String displayName) {
        this.displayName = displayName;
    }

}
