package groom.dashboardpractice.example;

import org.springframework.stereotype.Repository;

//@Repository
public interface MessageRepository {
    String findByKey(String key);
}
