package com.lofominhili.vaculator.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VacationResponse(

        @JsonProperty(value = "vacation_payment")
        double vacationPayment
) {
}
