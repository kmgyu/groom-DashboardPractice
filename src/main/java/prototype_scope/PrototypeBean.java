package prototype_scope;

import groom.dashboardpractice.lifecycle.WiredLifeCycleBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class PrototypeBean {
    public PrototypeBean() {
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
