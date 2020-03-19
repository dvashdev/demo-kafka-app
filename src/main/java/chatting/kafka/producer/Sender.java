package chatting.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    KafkaTemplate kafkaTemplate;
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    public Sender(@Qualifier("kafkaTemplate") KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String data) {
        LOGGER.info("sending data='{}' to topic='{}'", data, topic);
        kafkaTemplate.send(topic, data);
    }
}