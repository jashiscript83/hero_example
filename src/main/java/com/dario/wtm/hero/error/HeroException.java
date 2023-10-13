package com.dario.wtm.hero.error;

import lombok.Getter;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Getter
public class HeroException extends NestedRuntimeException {

    private final String code;

    private final String message;

    private final String detail;

    private final HttpStatus status;

    private final OffsetDateTime timestamp;

    public HeroException(HeroExceptionType type, String detail) {
        super(detail);
        this.code = type.code;
        this.message = type.description;
        this.detail = detail;
        this.status = type.status;
        this.timestamp = OffsetDateTime.now(ZoneOffset.UTC);
    }

    public HeroException(HeroExceptionType type, String detail, Throwable cause) {
        super(detail, cause);
        this.code = type.code;
        this.message = type.description;
        this.detail = detail;
        this.status = type.status;
        this.timestamp = OffsetDateTime.now(ZoneOffset.UTC);
    }

}
