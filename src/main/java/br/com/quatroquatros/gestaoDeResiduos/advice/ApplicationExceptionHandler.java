package br.com.quatroquatros.gestaoDeResiduos.advice;

import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException error){
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> fields = error.getBindingResult().getFieldErrors();
        for (FieldError field : fields){
            errorMap.put(field.getField(), field.getDefaultMessage());
        }
        return  errorMap;
    }


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleIntegridadeDados(DataIntegrityViolationException error){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", "usuário já cadastrado");
        System.out.println(error.getMessage());

        return  errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ModelNotFoundException.class)
    public Map<String, String> handleUserNotFound(ModelNotFoundException error){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", error.getMessage());

        return  errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleIllegalArgument(IllegalArgumentException error){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", error.getMessage());

        return  errorMap;
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public Map<String, String> handleAccessDenied(AccessDeniedException error){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", error.getMessage());

        return  errorMap;
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(BadCredentialsException.class)
    public Map<String, String> handleBadCredentials(BadCredentialsException error){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", "usuário não cadastrado ou credenciais inválidas");

        return  errorMap;
    }






}

