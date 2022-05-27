package com.example.demo.exception;


import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.ResponseDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AddressBookExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){

        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST requests",errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDTO> handleEmployeeNotFound(AddressBookException exception) {
        ResponseDTO response = new ResponseDTO("Invalid id input", exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
