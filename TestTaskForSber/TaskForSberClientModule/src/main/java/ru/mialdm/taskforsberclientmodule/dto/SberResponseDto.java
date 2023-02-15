package ru.mialdm.taskforsberclientmodule.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SberResponseDto {

    private String uuid;
    private String currentThread;
    private String lineById;
    private Timestamp timestamp;

}
