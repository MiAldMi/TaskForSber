package ru.mialdm.TaskForSber_ServerModule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SberRequestDto {

    private String uuid;
    private String currentThread;
    private String lineById;
    private Timestamp timestamp;

}
