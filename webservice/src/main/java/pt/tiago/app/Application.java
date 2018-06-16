package pt.tiago.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "pt.tiago")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}