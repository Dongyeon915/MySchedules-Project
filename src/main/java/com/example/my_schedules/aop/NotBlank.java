//package com.example.my_schedules.aop;
//
//import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuDTO;
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
////ConstraintValidator상속받아야한다 <처음은 만든 어노테이션 인터페이스>
//public class NotBlank implements ConstraintValidator<NotBlankCopy, Object> {
//    // 어노테이션이션에 정의된 함수 정보를 가져와서 조정이가능
//    @Override
//    public boolean isValid(Object value, ConstraintValidatorContext context) {
//        MenuDTO menuDTO = new MenuDTO();
//        if (value instanceof MenuDTO) {
//            menuDTO.setMenu_id(((MenuDTO) value).getMenu_id());
//            menuDTO.setName(((MenuDTO) value).getName());
//        }
//        if (menuDTO.getMenu_id() <= 0) {
//            return false;
//        } else {
//            return true;
//        }
//
//    }
//}
