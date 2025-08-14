package groom.dashboardpractice.manual_bean;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManualServiceTest {

    @Autowired
    private ManualService manualService;

    @Test
    void manualServiceBean_shouldBeRegisteredAndReturnExpectedValue() {
        // 빈이 정상적으로 주입되었는지 확인
        assertThat(manualService).isNotNull();

        // 기능이 정상 동작하는지 확인
        String result = manualService.stupid();
        assertThat(result).isEqualTo("you are stupid");
    }
}
