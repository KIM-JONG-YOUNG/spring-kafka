package edu.jong.spring.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jong.spring.kafka.producer.SpringKafkaProducer;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SpringKafkaController {

	private final SpringKafkaProducer producer;
	
	@GetMapping(value = "/send")
	ResponseEntity<Void> sendMessage(
			@RequestParam String message) {
		
		producer.sendMessage("spring-kafka-topic", message);
		
		return ResponseEntity.ok().build();
	}
	
}
