package com.example.my_schedules.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Date;
import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class TaskDTO {
    private Date date;
    private Integer userId;
    private Integer taskId;
    private String todoTask;
    private Boolean checkboxComplete;
    private Date completeTime;
}
