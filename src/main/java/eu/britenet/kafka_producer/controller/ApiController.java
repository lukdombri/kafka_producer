package eu.britenet.kafka_producer.controller;

import com.sun.net.httpserver.HttpServer;
import eu.britenet.kafka_producer.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final static String KAFKA_TOPIC = "testTopic";

    @PostMapping("/message")
    @ResponseBody
    public void produce(@RequestBody MessageDTO message){
        kafkaTemplate.send(KAFKA_TOPIC, message.getKey(),message.getText());
    }
}
