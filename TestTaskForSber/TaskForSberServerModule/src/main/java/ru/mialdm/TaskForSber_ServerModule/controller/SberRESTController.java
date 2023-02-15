package ru.mialdm.TaskForSber_ServerModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mialdm.TaskForSber_ServerModule.dto.SberRequestDto;
import ru.mialdm.TaskForSber_ServerModule.service.SberService;

import java.io.IOException;

@RestController
public class SberRESTController {

    private final SberService sberService;


    @Autowired
    public SberRESTController(SberService sberService) {
        this.sberService = sberService;
    }

    @PostMapping("/api")
    public ResponseEntity<SberRequestDto> getInfoById(@RequestBody SberRequestDto sberRequestDto) throws IOException {
        return ResponseEntity.ok().body(sberService.getTextInFileById(sberRequestDto));
    }
}
