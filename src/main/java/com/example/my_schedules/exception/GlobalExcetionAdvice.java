package com.example.my_schedules.exception;

// 로그 사용시 어노테이션
//@Slf4j
// 어디에 적용할지 basePackages
// 어노테이션을 여러개 사용하고 싶다면 {}, 사용@RestControllerAdvice(assignableTypes = {UserController.class, ExceptionController.class})
//@RestControllerAdvice

// 이딴 식으로 @RestControllerAdvice(basePackages = "com.example.springboot.controller.example.*")
//public class GlobalExcetionAdvice {
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> exceptionHandler01(Exception exception) {
//        log.error("Exception Class: {}", exception.getClass().getName());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//            .body("[Exception] " + exception.getClass().getName());
//    }
//// ㅇ
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<Object> exceptionHandler02(NullPointerException nullPointerException) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NullPointException");
//    }
//
////   예외를 상세히 나눠두면 밑에서 종류에 맞게 걸리고 없다면 최상위 Exception
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ResponseEntity<Object> parameterException(MissingServletRequestParameterException parameterException) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("parameterException");
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException parameterException, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
//        log.info(httpServletRequest.getMethod());
//        log.info("URI: {}", httpServletRequest.getRequestURI());
//        log.info("URL: {}", httpServletRequest.getRequestURL());
//        log.info("{}", httpServletRequest.getRemoteHost());
//        log.info("{}", httpServletRequest.getRemotePort());
//        log.info("{}", httpServletRequest.getRemoteAddr());
//        List<ErrorDto> errorList = new ArrayList<>();
//        if (bindingResult.hasErrors()) {
//            List<FieldError> errors = bindingResult.getFieldErrors();
//            for (FieldError error : errors) {
//                ErrorDto errorDto = new ErrorDto();
//                errorDto.setFiled(error.getField());
//                errorDto.setMessage(error.getRejectedValue().toString());
//                errorDto.setRejectedValue(error.getDefaultMessage());
//                errorList.add(errorDto);
//            }
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
//    }
//
//}
