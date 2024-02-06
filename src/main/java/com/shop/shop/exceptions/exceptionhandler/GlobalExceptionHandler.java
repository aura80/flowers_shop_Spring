package com.shop.shop.exceptions.exceptionhandler;

import com.shop.shop.exceptions.AlreadyExistsException;
import com.shop.shop.exceptions.InternalServerErrorException;
import com.shop.shop.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(NotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<String> resourceAlreadyExists(AlreadyExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<String> handleInternalServerErrorException(InternalServerErrorException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // de revizuit
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleMaxSizeExceededException(Model model, MaxUploadSizeExceededException exception) {
        model.addAttribute("Message", "File too large!");
        return new ResponseEntity<>(model.toString(), HttpStatus.PAYLOAD_TOO_LARGE);
    }

}
