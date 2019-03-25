package com.Kafka.SpringKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResources {

	@GetMapping("/hello")
	public String hello(){
	return "working";
	}
	@Autowired
	org.springframework.kafka.core.KafkaTemplate<String, String> KafkaTemplate;
	private static final String TOPIC="Kafka_Example";
	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") final String message){
		
		
		KafkaTemplate.send(TOPIC,message);
		return "Published Successfully";
		
	}
}
