package groom.dashboardpractice.aop;

import groom.dashboardpractice.crud.DashboardRepository;
import groom.dashboardpractice.crud.DashboardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {
    @Autowired DashboardRepository dashboardRepository;
    @Autowired DashboardService dashboardService;

    @Test
    void aopCheck() {
        // is aop check
        Assertions.assertThat(AopUtils.isAopProxy(dashboardRepository)).isTrue();
        Assertions.assertThat(AopUtils.isAopProxy(dashboardService)).isTrue();
    }
}
