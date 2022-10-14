package com.olsproject.onlinelotterysystem.error;


import com.olsproject.onlinelotterysystem.entity.ErrorMessage;
import com.olsproject.onlinelotterysystem.error.CannotRegister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus

public class RestResponseExceptionEntityHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CannotRegister.class)
    public ResponseEntity<ErrorMessage> cannotRegister(CannotRegister exception, WebRequest request){
        ErrorMessage message =new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
    }

    @ExceptionHandler(MoreUsersRequired.class)
    public ResponseEntity<ErrorMessage> moreUsersRequired(MoreUsersRequired exception, WebRequest request){
        ErrorMessage message =new ErrorMessage(HttpStatus.NOT_IMPLEMENTED,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(message);
    }
}
