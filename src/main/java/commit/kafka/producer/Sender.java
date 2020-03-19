package commit.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class Sender {

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void send(String topic, String data) {
        kafkaTemplate.send(topic, data);
    }
}
