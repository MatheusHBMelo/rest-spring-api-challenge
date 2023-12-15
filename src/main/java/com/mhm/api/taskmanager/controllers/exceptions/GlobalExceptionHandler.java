package com.mhm.api.taskmanager.controllers.exceptions;

import com.mhm.api.taskmanager.services.exceptions.DBException;
import com.mhm.api.taskmanager.services.exceptions.ListaDeObjetosVaziaException;
import com.mhm.api.taskmanager.services.exceptions.ObjetoNaoEncontradoException;
import com.mhm.api.taskmanager.services.exceptions.ObjetoNuloException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjetoNuloException.class)
    public ResponseEntity<StandardError> objetoNulo(ObjetoNuloException ex, HttpServletRequest request) {
        StandardError err = new StandardError(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<StandardError> objetoNaoEncontrado(ObjetoNaoEncontradoException ex, HttpServletRequest request) {
        StandardError err = new StandardError(ex.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ListaDeObjetosVaziaException.class)
    public ResponseEntity<StandardError> listaDeObjetossVazia(ListaDeObjetosVaziaException ex, HttpServletRequest request) {
        StandardError err = new StandardError(ex.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DBException.class)
    public ResponseEntity<StandardError> dbException(DBException ex, HttpServletRequest request) {
        StandardError err = new StandardError(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
