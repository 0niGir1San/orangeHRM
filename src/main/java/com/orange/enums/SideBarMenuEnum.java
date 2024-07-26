package com.orange.enums;

import lombok.Getter;

public enum SideBarMenuEnum {
    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");

    @Getter
    private final String menu;

    SideBarMenuEnum(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return this.menu;
    }
}
