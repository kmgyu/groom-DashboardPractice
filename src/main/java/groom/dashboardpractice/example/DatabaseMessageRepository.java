package groom.dashboardpractice.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Primary를 활용한 빈 주입
 */
@Component
@Primary
public class DatabaseMessageRepository implements MessageRepository {
    @Override
    public String findByKey(String key) {
        // DB 조회
        return "DB Hello, %s";
    }
}
