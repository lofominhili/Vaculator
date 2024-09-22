package com.lofominhili.vaculator.utils;

import com.lofominhili.vaculator.dto.basic.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling exceptions across all controllers.
 * This class is annotated with {@link ControllerAdvice} to define global exception handling.
 *
 * @author daniel
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception handler method for handling all types of exceptions.
     * It returns a ResponseEntity containing an ErrorDTO with details about the occurred exception.
     *
     * @param e The exception to handle.
     * @return A ResponseEntity containing an ErrorDTO with error details.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        ErrorDto errorDTO = new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.badRequest().body(errorDTO);
    }

    /**
     * Handles validation-related exceptions, such as those triggered by binding errors in request parameters.
     * This method builds a detailed error message string from the validation results and returns it in an {@link ErrorDto}.
     *
     * @param e The {@link BindException} that contains validation errors.
     * @return A {@link ResponseEntity} containing an {@link ErrorDto} with detailed validation error messages.
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorDto> handleValidationResults(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder message = new StringBuilder("Validation errors:");
        for (FieldError error : bindingResult.getFieldErrors()) {
            message.append(" ").append(error.getField()).append(": ").append(error.getDefaultMessage()).append(";");
        }
        return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getClass().getSimpleName(), message.toString()));
    }
}
