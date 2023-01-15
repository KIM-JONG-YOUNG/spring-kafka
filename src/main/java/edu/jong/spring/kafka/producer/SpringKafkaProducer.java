package edu.jong.spring.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SpringKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public void sendMessage(String topic, String message) {
    	
    	log.info("Topic Name   : {}", topic);
    	log.info("Send Message : {}", message);
    	
        this.kafkaTemplate.send(topic, message);
    }

}
