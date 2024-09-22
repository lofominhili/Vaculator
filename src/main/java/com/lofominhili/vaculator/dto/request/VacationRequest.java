package com.lofominhili.vaculator.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static com.lofominhili.vaculator.utils.Constants.NOT_NULL_MESSAGE;

public record VacationRequest(

        @JsonProperty(value = "average_salary")
        @NotNull(message = NOT_NULL_MESSAGE)
        Double averageSalary,

        @JsonProperty(value = "vacation_days")
        @NotNull(message = NOT_NULL_MESSAGE)
        Integer vacationDays,

        @JsonProperty(value = "start_date")
        LocalDate startDate,

        @JsonProperty(value = "end_date")
        LocalDate endDate
) {
}
