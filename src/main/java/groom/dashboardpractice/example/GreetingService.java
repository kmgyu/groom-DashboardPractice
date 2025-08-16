package groom.dashboardpractice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GreetingService {
    private final MessageRepository repo;
    private final String prefix;

    public GreetingService(@Qualifier("InMemoryMessageRepository") MessageRepository repo, String prefix) {
        this.repo = repo;
        this.prefix = prefix;
    }

    public String greet(String name) {
        return prefix + " " + String.format(repo.findByKey("greet"), name);
    }
}
