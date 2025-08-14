package groom.dashboardpractice.circular_dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


// 해결하는 가장 좋은 방법 : 연결 끊기.
// 아래처럼 할 시, 오류 찾기가 수월해짐.

@Component
class Example11 {
    //
    private Example22 example22;

//  생성자 주입, 가장 권장되는 방식
    @Autowired
    public Example11( Example22 example22 ) {
        this.example22 = example22;
    }

    public void doJob2() {
        example22.doJob1();
    }
}

@Component
class Example22 {
    // 방법 1. 실제 빈 생성 시점에는 프록시 객체 주입.
    // 이런 식의 순환참조에서 실제로는 비어있다.
    @Autowired
    @Lazy
    private Example11 example11;

    public void doJob1() {
        example11.doJob2();
    }
}

//    @Component
//    public class Example3 {
//        // 방법 2. Setter를 이용한 주입
//        // 순환 참조 탐지 시, 스프링이 실패시킨다.
//        private Example2 example2;
//
//        @Autowired
//        public void setExample2(Example2 example2) {
//            this.example2 = example2;
//        }
//    }

//    방법 3.
//    @Component
//    public class Example4 {
//        @Autowired
//        private ApplicationEventPublisher publisher;
//
//        public void doJob4() {
//            publisher.publishEvent(new Job5Event(this));
//        }
//    }
//
//    @Component
//    public class Example5 {
//        @EventListener
//        public void handleJob5(Job5Event event) {
//            doJob4();
//        }
//    }

//    방법 4. ObjectProvider를 이용한 지연조회
//    HTTP에서 사용되는 빈처럼 필요할 때만 살리는? 그런 것...
//    필요시에만 가져올 수 있음.
//    @Component
//    public class Example1 {
//        @Autowired
//        private ObjectProvider<Example2> example2Provider;
//
//        public void doJob2() {
//            example2Provider.getObject().doJob1();
//        }
//    }

@SpringBootTest
public class CircularDependencyGoodTest {
    //    순환 참조 컴포넌트

    @Autowired
    private Example11 example1;

    @Autowired
    @Lazy
    private Example22 example2;

    @Test
    void circularDependencyGoodExample() {
        // 순환 참조 - 나쁜 예제
        example1.doJob2();
        example2.doJob1();

// 나쁜 예에서는 확인 못했는데(문구가 너무 많아서 스크롤하다가 확인 못햇다...)
// 순환 참조시 다음과 같은 메시지를 출력한다.

//***************************
//APPLICATION FAILED TO START
//***************************
//
//        Description:
//
//        The dependencies of some of the beans in the application context form a cycle:
//
//┌─────┐
//|  example1 (field private groom.dashboardpractice.circular_dependency.Example2 groom.dashboardpractice.circular_dependency.Example1.example2)
//↑     ↓
//|  example2 (field private groom.dashboardpractice.circular_dependency.Example1 groom.dashboardpractice.circular_dependency.Example2.example1)
//└─────┘

    }
}
