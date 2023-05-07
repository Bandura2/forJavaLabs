package ua.lviv.iot.part1.lab6.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "ua.lviv.iot.part1.lab6")
@SpringBootApplication
public class SixJavaLabApplication {
    public static void main(final String[] args) {
        SpringApplication.run(SixJavaLabApplication.class, args);
    }
}
