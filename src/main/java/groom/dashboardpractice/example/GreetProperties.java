package groom.dashboardpractice.example;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

/**
 * 테스트를 위한 일종의 dto
 */
@Validated
@ConfigurationProperties(prefix = "app.greet")
public class GreetProperties {
    @NotBlank
    private String prefix;
    @NotEmpty
    private Map<String,String> messages;

    // getters/setters
    public String getPrefix() { return prefix; }
    public void setPrefix(String prefix) { this.prefix = prefix; }
    public Map<String, String> getMessages() { return messages; }
    public void setMessages(Map<String, String> messages) { this.messages = messages; }
}
