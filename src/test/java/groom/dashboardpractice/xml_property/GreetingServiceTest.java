package groom.dashboardpractice.xml_property;

import groom.dashboardpractice.example.GreetProperties;
import groom.dashboardpractice.example.GreetingService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreetingServiceTest {
    @Autowired
    GreetingService greetingService;
    @Autowired
    GreetProperties props;

    @Test
    void wiring_and_behavior() {
        Assertions.assertThat(props.getPrefix()).isEqualTo("[DEV]");
        Assertions.assertThat(greetingService.greet("Minkyu"))
//                .isEqualTo("[DEV] Hello, Minkyu");
                .isEqualTo("[DEV] DB Hello, Minkyu"); // primary가 DB라 DB Hello로 바뀐다.
    }
}
