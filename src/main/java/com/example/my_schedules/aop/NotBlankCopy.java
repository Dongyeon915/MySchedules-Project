//package com.example.my_schedules.aop;
//
//import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
//import static java.lang.annotation.ElementType.CONSTRUCTOR;
//import static java.lang.annotation.ElementType.FIELD;
//import static java.lang.annotation.ElementType.METHOD;
//import static java.lang.annotation.ElementType.PARAMETER;
//import static java.lang.annotation.ElementType.TYPE_USE;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//import javax.validation.Constraint;
//import javax.validation.Payload;
//
//@Documented
//// Validation을 정의할 클래스를 먼저 정의해야 오류없음
////  ConstraintHelper가 확인하는 필드 이므로 필수적인 3개
//
//@Constraint(validatedBy = {NotBlank.class})
//@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
//@Retention(RUNTIME)
//public @interface NotBlankCopy {
//    String message() default "{아이디가 0이하야}";
//
//    Class<?>[] groups() default { };
//
//    Class<? extends Payload>[] payload() default { };
//}
