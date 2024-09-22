package com.lofominhili.vaculator.services;

import com.lofominhili.vaculator.dto.request.VacationRequest;
import com.lofominhili.vaculator.dto.response.VacationResponse;

public interface VaculatorService {

    public VacationResponse calculateVacation(VacationRequest request);

}
