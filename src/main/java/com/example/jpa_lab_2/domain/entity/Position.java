package com.example.jpa_lab_2.domain.entity;

import lombok.Getter;

public enum Position {
    DEPARTMENT_HEAD("head of department"),
    BRANCH_HEAD("head of branch"),
    EMPLOYEE("employee"),
    MANAGER("manager"),
    DEVELOPER("developer");

    @Getter
    private final String displayName;

    private Position(String displayName) {
        this.displayName = displayName;
    }

}
