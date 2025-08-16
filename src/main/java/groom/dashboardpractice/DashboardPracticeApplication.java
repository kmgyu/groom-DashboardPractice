package groom.dashboardpractice;

import groom.dashboardpractice.example.GreetProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GreetProperties.class)
public class DashboardPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardPracticeApplication.class, args);
    }

}
