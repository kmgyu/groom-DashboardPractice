package groom.dashboardpractice.circular_dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

//    순환 참조 컴포넌트
@Component
class Example1 {
    @Autowired
    private Example2 example2;

    public void doJob2() {
        example2.doJob1();
    }
}

@Component
class Example2 {
    @Autowired
    private Example1 example1;

    public void doJob1() {
        example1.doJob2();
    }
}

@SpringBootTest
public class CircularDependencyBadTest {

    @Autowired
    private Example1 example1;

    @Autowired
    private Example2 example2;

    @Test
    void circularDependencyBadExample() {
        // 순환 참조 - 나쁜 예제
        example1.doJob2();
        example2.doJob1();
// 에러가 발생한다.
// 해석하기도 어렵다..! Autowired 부분에서 계속해서 참조하다가 꼬이고 꼬인 것으로 보임.
//        Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException
//        Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException
//        Error creating bean with name 'example1': Unsatisfied dependency expressed through field 'example2': Error creating bean with name 'example2' ~...
    }
}
