package com.example.my_schedules.dto;

import java.time.LocalDate;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private int userId;
    private String userEmail;
    @Size(min = 4,max = 20)
    private String userPassword;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
}
