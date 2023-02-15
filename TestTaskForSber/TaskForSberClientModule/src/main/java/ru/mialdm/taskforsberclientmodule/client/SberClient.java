package ru.mialdm.taskforsberclientmodule.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ru.mialdm.taskforsberclientmodule.dto.SberResponseDto;


import java.sql.Timestamp;
import java.time.Duration;
import java.util.UUID;

@Component
@Slf4j
public class SberClient {

    private final WebClient webClient;

    @Autowired
    public SberClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public SberResponseDto getInfo(Integer id) {

        SberResponseDto sberResponseDto = new SberResponseDto();
        sberResponseDto.setUuid(String.valueOf(UUID.randomUUID()));
        sberResponseDto.setLineById(id.toString());
        sberResponseDto.setCurrentThread(Thread.currentThread().getName());
        sberResponseDto.setTimestamp(new Timestamp(System.currentTimeMillis()));

        log.info(String.format("Thread and Request ID Info: Thread-%s, Request ID-%s", sberResponseDto.getCurrentThread(), sberResponseDto.getUuid()));

        return webClient.post()
                .uri("/api")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(sberResponseDto))
                .retrieve()
                .bodyToMono(SberResponseDto.class)
                .timeout(Duration.ofSeconds(2))
                .block();
    }
}
