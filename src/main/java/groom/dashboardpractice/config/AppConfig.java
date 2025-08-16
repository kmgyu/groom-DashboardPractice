package groom.dashboardpractice.config;

import groom.dashboardpractice.example.GreetProperties;
import groom.dashboardpractice.example.GreetingService;
import groom.dashboardpractice.example.InMemoryMessageRepository;
import groom.dashboardpractice.example.MessageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    MessageRepository messageRepository(GreetProperties props) {
        return new InMemoryMessageRepository(props.getMessages());
    }

    @Bean
    GreetingService greetingService(MessageRepository repo, GreetProperties props) {
        return new GreetingService(repo, props.getPrefix());
    }
}
