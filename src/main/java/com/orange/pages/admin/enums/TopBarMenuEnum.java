package com.orange.pages.admin.enums;

import lombok.Getter;

public enum TopBarMenuEnum {

    USER_MANAGEMENT("User Management"),
    JOB("Job"),
    ORGANIZATION("Organization"),
    QUALIFICATIONS("Qualifications"),
    NATIONALITIES("Nationalities"),
    CORPORATE_BRANDING("Corporate Branding"),
    CONFIGURATION("Configuration");

    @Getter
    private final String menu;

    TopBarMenuEnum(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return this.menu;
    }
}
