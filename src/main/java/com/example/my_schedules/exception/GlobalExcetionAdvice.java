package com.example.my_schedules.exception;

// 로그 사용시 어노테이션

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
// 어디에 적용할지 basePackages
// 어노테이션을 여러개 사용하고 싶다면 {}, 사용@RestControllerAdvice(assignableTypes = {UserController.class, ExceptionController.class})
//@RestControllerAdvice
//    (basePackages = "com.example.my_schedules.controller.todo_controller.*")
@RestControllerAdvice(basePackages = "com.example.my_schedules.controller.todo_controller.*")
public class GlobalExcetionAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandler01(Exception exception) {
        log.error("Exception Class: {}", exception.getClass().getName());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("[Exception] " + exception.getClass().getName());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> exceptionHandler02(NullPointerException nullPointerException) {
        log.error("Exception Class: {}", nullPointerException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NullPointException");
    }

//   예외를 상세히 나눠두면 밑에서 종류에 맞게 걸리고 없다면 최상위 Exception
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ResponseEntity<Object> parameterException(MissingServletRequestParameterException parameterException) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("parameterException");
//    }

}
