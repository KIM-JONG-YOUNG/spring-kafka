package edu.jong.spring.kafka.consumer;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SpringKafkaConsumer {

    @KafkaListener(
    		topics = "spring-kafka-topic", 
    		groupId = "spring-kafka-consumer")
    public void consume(String message) throws IOException {
        log.info("Topic Name      : spring-kafka-topic");
        log.info("Consume Message : {}", message);
    }

}
