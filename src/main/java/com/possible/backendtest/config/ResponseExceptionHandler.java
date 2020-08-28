package com.possible.backendtest.config;

import com.possible.backendtest.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {


        @ExceptionHandler(CustomException.class)
        public ResponseEntity<Object> handleCustomException(CustomException ce) {
            ApiResponse<?> ar = new ApiResponse<>(ce.getStatus());
            ar.setError(ce.getMessage());
            return buildResponseEntity(ar);
        }

        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity<Object> handleCustomException(MethodArgumentTypeMismatchException ce) {
            ApiResponse<?> ar = new ApiResponse<>(HttpStatus.BAD_REQUEST);
            ar.setError("Invalid card number");
            return buildResponseEntity(ar);
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                      HttpStatus status, WebRequest request) {
            ApiResponse<?> response = new ApiResponse<>(HttpStatus.BAD_REQUEST);
            response.setMessage("Validation Error");
            return buildResponseEntity(response);
        }

        @Override
        protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                              HttpHeaders headers, HttpStatus status, WebRequest request) {
            String error = ex.getParameterName() + " parameter is missing";
            System.out.println(error);
            return buildResponseEntity(new ApiResponse<>(HttpStatus.BAD_REQUEST, error));
        }

        private ResponseEntity<Object> buildResponseEntity(ApiResponse<?> apiResponse) {
            return new ResponseEntity<>(apiResponse, apiResponse.getStatus());
        }

}
