package groom.dashboardpractice.example;

import org.springframework.beans.factory.annotation.Autowired;

public class GreetingService {
    private final MessageRepository repo;
    private final String prefix;

    @Autowired
    public GreetingService(MessageRepository repo, String prefix) {
        this.repo = repo;
        this.prefix = prefix;
    }
    public String greet(String name) {
        return prefix + " " + String.format(repo.findByKey("greet"), name);
    }
}
