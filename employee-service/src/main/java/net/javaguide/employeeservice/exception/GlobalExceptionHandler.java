package net.javaguide.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice// 相当于把GlobalExceptionHandler里的函数放到了controller里面
public class GlobalExceptionHandler {
   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                       WebRequest webRequest) {
      ErrorDetails errorDetails = new ErrorDetails(
              LocalDateTime.now(),
              resourceNotFoundException.getMessage(),
              webRequest.getDescription(false),
              "EMPLOYEE_NOT_FOUND"
      );
      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(EmailAlreadyExistsException.class)
   public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception,
                                                                       WebRequest webRequest) {
      ErrorDetails errorDetails = new ErrorDetails(
              LocalDateTime.now(),
              exception.getMessage(),
              webRequest.getDescription(false),
              "EMPLOYEE_EMAIL_ALREADY_EXISTS"
      );
      return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<ErrorDetails> handleException(Exception exception,
                                                                         WebRequest webRequest) {
      ErrorDetails errorDetails = new ErrorDetails(
              LocalDateTime.now(),
              exception.getMessage(),
              webRequest.getDescription(false),
              "INTERNAL_SERVER_ERROR"
      );
      return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
