package com.example.my_schedules.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class TaskDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Integer userId;
    private Integer taskId;
    private String todoTask;
    private Boolean checkboxComplete;
    private Date completeTime;
}
