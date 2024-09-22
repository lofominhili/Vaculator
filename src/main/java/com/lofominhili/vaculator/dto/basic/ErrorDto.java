package com.lofominhili.vaculator.dto.basic;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorDto(

        @JsonProperty(value = "status_code")
        Integer statusCode,

        String exception,

        String message
) {
}
