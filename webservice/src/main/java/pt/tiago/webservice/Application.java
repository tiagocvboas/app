package pt.tiago.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pt.tiago")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}