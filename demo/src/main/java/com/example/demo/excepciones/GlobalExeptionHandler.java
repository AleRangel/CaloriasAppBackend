package com.example.demo.excepciones;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.dto.ErrorDetalles;

@ControllerAdvice
public class GlobalExeptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(RecursoNoEncontrado.class)
    public ResponseEntity<ErrorDetalles>ManejarResourceNotFoundException(RecursoNoEncontrado exception,WebRequest webRequest) {

        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), exception.getMessage(), webRequest.getDescription(false));
        
        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorDetalles>manejarAppException(AppException exception,WebRequest webRequest) {

        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), exception.getMessage(), webRequest.getDescription(false));
        
        return new ResponseEntity<>(errorDetalles, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetalles>manejarGlobalException(Exception exception,WebRequest webRequest) {

        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), exception.getMessage(), webRequest.getDescription(false));
        
        return new ResponseEntity<>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
            
                Map<String, String> errores = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) ->{
                    String nombreCampo = ((FieldError) error).getField();
                    String mensaje = error.getDefaultMessage();        
                    errores.put(nombreCampo, mensaje);
                });
                return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
        
                    
    }

    
    
}