package ru.mialdm.TaskForSber_ServerModule.service;

import ru.mialdm.TaskForSber_ServerModule.dto.SberRequestDto;

import java.io.IOException;

public interface SberService {

    SberRequestDto getTextInFileById (SberRequestDto sberRequestDto) throws IOException;
}
