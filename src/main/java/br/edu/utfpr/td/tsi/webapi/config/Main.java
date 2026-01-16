package br.edu.utfpr.td.tsi.webapi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.webapi")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
