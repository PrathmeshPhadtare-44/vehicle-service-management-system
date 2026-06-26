package com.prathmesh.vsms.exception;
import com.prathmesh.vsms.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidation(
            MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .toList();

        ErrorResponseDto error = new ErrorResponseDto();
                    error.setStatus(HttpStatus.NOT_FOUND.value());
                    error.setMessage(error.getMessage());
                    error.setTimestamp(LocalDateTime.now());
                    return ResponseEntity.badRequest().body(error);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> resourceNotFound(ResourceNotFoundException ex)
    {
        ErrorResponseDto error = new ErrorResponseDto();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(List.of(ex.getMessage()));
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

}
