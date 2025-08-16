package groom.dashboardpractice.example;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InMemoryMessageRepository implements MessageRepository {
    private final Map<String,String> messages;

    public InMemoryMessageRepository(Map<String,String> messages) {
        this.messages = messages;
    }

    @Override public String findByKey(String key) {
        return messages.getOrDefault(key, "N/A");
    }
}
