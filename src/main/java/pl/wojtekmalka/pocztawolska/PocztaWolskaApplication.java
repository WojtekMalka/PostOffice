package pl.wojtekmalka.pocztawolska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.wojtekmalka.pocztawolska.service.QueueServiceImpl;

@SpringBootApplication
public class PocztaWolskaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PocztaWolskaApplication.class, args);
    }

}
