package com.lofominhili.vaculator.services;

import com.lofominhili.vaculator.dto.request.VacationRequest;
import com.lofominhili.vaculator.dto.response.VacationResponse;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
class VaculatorServiceTest {

    private final VaculatorService vaculatorService;

    @Test
    void testVacationWithoutHolidays() {
        VacationRequest request = new VacationRequest(
                60000.0,
                10,
                null,
                null
        );

        VacationResponse response = vaculatorService.calculateVacation(request);
        assertEquals(20478.16, response.vacationPayment(), 0.01);
    }

    @Test
    void testVacationWithHolidays() {
        VacationRequest request = new VacationRequest(
                60000.0,
                10,
                LocalDate.of(2024, 5, 1),
                LocalDate.of(2024, 5, 10)
        );

        VacationResponse response = vaculatorService.calculateVacation(request);
        assertEquals(14334.49, response.vacationPayment(), 0.01);
    }
}
