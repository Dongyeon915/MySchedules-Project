package com.example.my_schedules.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDate;
import java.util.Date;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class TaskDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String userId;
    private Integer taskId;
    @Size(min = 1,max = 100)
    private String todoTask;
    private Boolean checkboxComplete;
    private Date completeTime;
    private Integer memberId;
}
