package org.enset.kafkadotnet;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Service
public class SpringKafkaConsumer {
    @Autowired
    Logger logger;

    @Bean
    Logger initLogger() throws IOException {
        Logger logger=Logger.getLogger(this.getClass().getName());
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
        return logger;
    }

    @KafkaListener(topics = ApplicationConstant.TOPIC_NAME,groupId = ApplicationConstant.GROUP_ID_STRING,containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void message(ConsumerRecord<String,String> consumerRecord){
        System.out.println("Message recu by utilisant kafka : "+consumerRecord.value());
        logger.info(consumerRecord.value());
    }
}
