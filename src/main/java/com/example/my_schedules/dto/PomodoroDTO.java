package com.example.my_schedules.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Data
@JsonInclude(Include.NON_NULL)
public class PomodoroDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
//  Local데이트 날만 받는다
    private LocalDate date;
    private String userId;
    private Integer pomoId;
    private Integer restInterval;
    private Integer interval;
    private Integer minute;
    private Integer rest;
}
