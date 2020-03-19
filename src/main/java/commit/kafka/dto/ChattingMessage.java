package commit.kafka.dto;

import lombok.Data;

@Data
public class ChattingMessage {
    private String message;
    private String user;
}
