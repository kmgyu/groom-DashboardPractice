package groom.dashboardpractice.config;

import groom.dashboardpractice.manual_bean.ManualService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DashboardConfig {

    @Bean
    public ManualService manualService() {
        return new ManualService();
    }

}
