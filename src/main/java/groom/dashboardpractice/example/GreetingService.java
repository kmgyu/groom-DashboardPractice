package groom.dashboardpractice.example;

public class GreetingService {
    private final MessageRepository repo;
    private final String prefix;
    public GreetingService(MessageRepository repo, String prefix) {
        this.repo = repo;
        this.prefix = prefix;
    }
    public String greet(String name) {
        return prefix + " " + String.format(repo.findByKey("greet"), name);
    }
}
