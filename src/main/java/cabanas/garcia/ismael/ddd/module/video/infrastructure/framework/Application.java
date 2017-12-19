package cabanas.garcia.ismael.ddd.module.video.infrastructure.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.configuration",
        "cabanas.garcia.ismael.ddd.module.video.infrastructure.framework.controller"
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
