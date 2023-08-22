package com.prueba.fonyou.dto;


import com.prueba.fonyou.entity.TimeZoneEnum;
import lombok.*;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private TimeZoneEnum timeZone;
    private LocalDate date;
    private Long idExam;
    private Map<Long, Character> answers;
    private Long idAnswer;
}
