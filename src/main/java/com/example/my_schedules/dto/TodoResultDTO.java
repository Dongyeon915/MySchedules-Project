package com.example.my_schedules.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Date;
import lombok.Data;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class TodoResultDTO {
    private Integer userId;
    private Date date;
    private Integer restTask;
    private Integer clearTask;
}
