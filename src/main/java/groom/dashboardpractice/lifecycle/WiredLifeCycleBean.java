package groom.dashboardpractice.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class WiredLifeCycleBean {
    public WiredLifeCycleBean() {
        System.out.println("WiredLifeCycleBean created");
    }

    @PostConstruct
    public void init() {
        System.out.println("WiredLifeCycleBean init");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("WiredLifeCycleBean destroy");
    }
}
