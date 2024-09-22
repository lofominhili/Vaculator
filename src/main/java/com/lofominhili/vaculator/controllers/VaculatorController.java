package com.lofominhili.vaculator.controllers;

import com.lofominhili.vaculator.dto.basic.SuccessDto;
import com.lofominhili.vaculator.dto.request.VacationRequest;
import com.lofominhili.vaculator.dto.response.VacationResponse;
import com.lofominhili.vaculator.services.VaculatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for vacation payment calculation.
 * Handles requests related to calculating vacation payments, accepting the average salary
 * and number of vacation days, and performs data validation.
 *
 * @author daniel
 */
@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class VaculatorController {

    private final VaculatorService vaculatorService;

    /**
     * API method to calculate vacation payments.
     * Accepts a request containing the average salary for 12 months and the number of vacation days,
     * and checks for validation errors. If validation errors are present, an exception is thrown.
     *
     * @param request          A {@link VacationRequest} object containing data for vacation calculation.
     * @return {@link ResponseEntity} containing a {@link SuccessDto} object that includes the result
     * of the vacation calculation in the form of a {@link VacationResponse}.
     */
    @GetMapping
    public ResponseEntity<SuccessDto<VacationResponse>> calculateVacation(@Valid @RequestBody VacationRequest request){
        return new ResponseEntity<>(
                new SuccessDto<>(
                        HttpStatus.OK.value(),
                        "calculate",
                        vaculatorService.calculateVacation(request)
                ), HttpStatus.OK);

    }
}