package groom.dashboardpractice.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

public class LifeCycleTest {


    @Autowired
    ApplicationContext ac;

    @Autowired
    LifeCycleBean bean;

    @Test
    void testLifeCycle() {
        LifeCycleBean bean2 = ac.getBean(LifeCycleBean.class);
        assertThat(bean).isSameAs(bean2);   // 같은 인스턴스여야 함
        bean.destroy();
    }
}
