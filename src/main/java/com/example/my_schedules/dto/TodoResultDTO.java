package com.example.my_schedules.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class TodoResultDTO {
    private String userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Integer restTask;
    private Integer clearTask;
}
