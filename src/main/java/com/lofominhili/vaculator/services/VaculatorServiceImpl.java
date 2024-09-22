package com.lofominhili.vaculator.services;

import com.lofominhili.vaculator.dto.request.VacationRequest;
import com.lofominhili.vaculator.dto.response.VacationResponse;
import com.lofominhili.vaculator.utils.Holiday;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Service implementation of {@link VaculatorService} for vacation payment calculation.
 * This class contains the business logic for calculating vacation payments
 * based on the average salary, vacation days, and optional vacation dates.
 *
 * @author daniel
 */
@Service
public class VaculatorServiceImpl implements VaculatorService {

    /**
     * Calculates the vacation payment based on the provided {@link VacationRequest}.
     * It computes the average daily salary and multiplies it by the number of vacation days.
     * If specific vacation dates are provided, holidays and weekends are excluded from the calculation.
     *
     * @param request The {@link VacationRequest} containing the average salary,
     *                number of vacation days, and optional start and end vacation dates.
     * @return A {@link VacationResponse} containing the calculated vacation payment amount.
     */
    @Override
    public VacationResponse calculateVacation(VacationRequest request) {
        double averageDailySalary = request.averageSalary() / 29.3;
        int vacationDays = request.vacationDays();

        if (request.startDate() != null && request.endDate() != null) {
            List<LocalDate> holidaysAndWeekends = Holiday.getHolidaysAndWeekends(request.startDate(), request.endDate());
            vacationDays -= holidaysAndWeekends.size();
        }

        double vacationPayment = averageDailySalary * vacationDays;
        return new VacationResponse(vacationPayment);
    }
}
