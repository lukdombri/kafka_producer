package eu.britenet.kafka_producer.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private String key;
    private String text;
}
