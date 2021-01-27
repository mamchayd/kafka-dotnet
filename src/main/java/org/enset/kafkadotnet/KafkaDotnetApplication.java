package org.enset.kafkadotnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaDotnetApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDotnetApplication.class, args);
    }

}
