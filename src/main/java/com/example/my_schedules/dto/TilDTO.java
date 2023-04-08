package com.example.my_schedules.dto;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TilDTO {

    private int tuiId;
    private String tuiTitle;
    private String tuiContent;
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;
}
