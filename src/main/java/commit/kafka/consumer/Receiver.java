package commit.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class Receiver {
    private CountDownLatch countDownLatch = new CountDownLatch(1);
//    @Autowired
//    private SimpMessagingTemplate template;

    @KafkaListener(topics = "${topic.boot}")
    public void receive(ConsumerRecord<?,?> consumerRecord) {
        String[] message = consumerRecord.value().toString().split("\\|");
        System.out.println(message);
    }
}
