//package com.example.my_schedules.controller.todo_controller;
//
//import com.example.my_schedules.dao.AuthorityDAO;
//import com.example.my_schedules.dao.MemberDAO;
//import com.example.my_schedules.dto.AuthorityDTO;
//import com.example.my_schedules.dto.MemberDTO;
//import java.util.List;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/join")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class MemberController {
//
//    @Autowired
//    MemberDAO memberDAO;
//    @Autowired
//    AuthorityDAO authorityDAO;
//
//    @GetMapping
//    public List<MemberDTO> getMember() {
//        return memberDAO.getMember();
//    }
//
//    @PostMapping
//    public ResponseEntity<Object> setMember(@Valid @RequestBody MemberDTO memberDTO) {
//        AuthorityDTO authorityDTO = new AuthorityDTO();
//        authorityDTO.setAuthority("ROLE_Guest");
//        authorityDAO.setUserAuthority(authorityDTO);
//        memberDTO.setUserPassword(new BCryptPasswordEncoder().encode(memberDTO.getUserPassword()));
//        int dto = memberDAO.setMember(memberDTO);
//        if (dto != 1) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email 중복체크를 해주세요.");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body("환영합니다");
//    }
//
//    @PostMapping("/check")
//    public ResponseEntity<Object> emailCheck(@RequestBody MemberDTO memberDTO) {
//        MemberDTO dto = memberDAO.emailCheck(memberDTO);
//        if (dto != null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 가입된 이메일입니다.");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body("가입가능한 이메일입니다");
//    }
//}
