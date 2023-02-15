package ru.mialdm.TaskForSber_ServerModule.service;

import au.com.bytecode.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mialdm.TaskForSber_ServerModule.dto.SberRequestDto;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SberServiceImpl implements SberService {

    private static final String PATH = "TaskForSberServerModule/src/main/resources/airports.dat";

    @Override
    public SberRequestDto getTextInFileById(SberRequestDto sberRequestDto) throws IOException {

        log.info(String.format("Client Info: UUID-%s, Thread-%s, ID-%s, Timestamp-%s",sberRequestDto.getUuid(), sberRequestDto.getCurrentThread(), sberRequestDto.getLineById(), sberRequestDto.getTimestamp()));

        CSVReader csvReader = new CSVReader(new FileReader(PATH), ',' ,'"' ,0);
        List<String[]> allRows = csvReader.readAll();
        for(String[] row : allRows) {
            if (row[0].equals(sberRequestDto.getLineById())) {
                sberRequestDto.setLineById(Arrays.toString(row));
            }
        }
        return sberRequestDto;
    }
}
