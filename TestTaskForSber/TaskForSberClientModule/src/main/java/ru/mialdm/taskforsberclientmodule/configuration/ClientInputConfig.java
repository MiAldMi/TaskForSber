package ru.mialdm.taskforsberclientmodule.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.mialdm.taskforsberclientmodule.client.SberClient;

import java.util.Scanner;

@Component
@AllArgsConstructor
public class ClientInputConfig {

    private SberClient sberClient;

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID: ");

        while (scanner.hasNext()) {
            System.out.println(sberClient.getInfo(scanner.nextInt()));
            System.out.print("Введите ID: ");
        }
    }
}
