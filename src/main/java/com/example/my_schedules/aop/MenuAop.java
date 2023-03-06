//package com.example.my_schedules.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
////@Aspect와 @Component Annotation을 이용하여 AOP 기능 구현을 시작합니다.
//@Aspect
//@Component
//@Slf4j
//public class MenuAop {
////  @Pointcut을 이용하여 AOP가 적용될 대상을 지정해야 합니다.
//    @Pointcut("execution(* com.naver.ehd9567.hollys_backend..*.*(..))")
//    public void aopRange(){
//
//    }
//
////    @Before("aopRange()")
//////  클라이언트가 호출한 비즈니스 Method의 정보가 JoinPoint에 담겨있으며 JointPoint를 사용하여 각종 정보 확인이 가능합니다.
////    public void beforAction(JoinPoint joinPoint){
////        System.out.println("[Before]");
////       Object[] objects = joinPoint.getArgs();
////       for (Object obj : objects){
////           System.out.println(obj.getClass().getSimpleName());
////       }
////    }
//
////    @AfterReturning(value = "aopRange()",returning = "obj")
////    public Object afterReturningAction(JoinPoint joinPoint,Object obj){
////        System.out.println("[AfterReturning]");
////        if (obj instanceof MenuDTO){
////            MenuDTO menu = (MenuDTO) obj;
////                System.out.println(menu.getMenu_id());
////                System.out.println(menu.getName());
////        }
////        return obj;
////    }
//}
