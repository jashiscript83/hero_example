package com.dario.wtm.hero.error;

import org.springframework.http.HttpStatus;

public enum HeroExceptionType {

    RESOURCE_MALFORMED(HttpStatus.BAD_REQUEST, "401", "Resource data was malformed or missing."),


    RESOURCE_MISSING(HttpStatus.NOT_FOUND, "402", "Resource is missing or user cannot view it.");

    public final HttpStatus status;

    public final String code;

    public final String description;

    HeroExceptionType(HttpStatus status, String code, String description) {
        this.status = status;
        this.code = code;
        this.description = description;
    }

}
