package org.enset.kafkadotnet;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringKafkaConfig {
    @Bean
    ConsumerFactory<String,String> consumerFactory(){
        Map<String, Object> config=new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,ApplicationConstant.KAFKA_LOCAL_SERVER_CONFIG);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,ApplicationConstant.GROUP_ID_STRING);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }
    @Bean
    ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory factory=new
                ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
