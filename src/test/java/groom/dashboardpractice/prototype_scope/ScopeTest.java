package groom.dashboardpractice.prototype_scope;

import groom.dashboardpractice.lifecycle.LifeCycleBean;
import groom.dashboardpractice.lifecycle.WiredLifeCycleBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import prototype_scope.PrototypeBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ScopeTest {

    @Test
    void beanScopeTest() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find bean1");
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);

        System.out.println("find bean2");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

        System.out.println("bean1 : " + bean1);
        System.out.println("bean2 : " + bean2);

        Assertions.assertThat(bean1).isNotSameAs(bean2);

        bean1.destroy();
        bean2.destroy();

        ac.close();
    }

    /**
     * Singletone Scope
     * Lifecycle bean 재활용.
     */
    @Test
    void beanScopeTest2() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(WiredLifeCycleBean.class);

        WiredLifeCycleBean bean1 = ac.getBean(WiredLifeCycleBean.class);
        WiredLifeCycleBean bean2 = ac.getBean(WiredLifeCycleBean.class);
        assertThat(bean1).isSameAs(bean2);   // 같은 인스턴스여야 함

        ac.close();
    }
}
