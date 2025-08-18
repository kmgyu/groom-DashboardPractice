package groom.dashboardpractice.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean {
    private final WiredLifeCycleBean bean;

    @Autowired
    public LifeCycleBean(WiredLifeCycleBean bean) {
        this.bean = bean;
        System.out.println("LifeCycleBean created");
    }

    @PostConstruct
    public void init() {
        System.out.println("LifeCycleBean init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("LifeCycleBean destroy");
    }
}
