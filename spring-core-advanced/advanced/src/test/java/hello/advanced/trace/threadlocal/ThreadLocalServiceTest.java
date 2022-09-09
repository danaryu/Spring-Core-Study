package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.ThreadLocalLogTraceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalLogTraceService service = new ThreadLocalLogTraceService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            service.logic("userA");
        };
        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); // 동시성 문제가 발생하지 않음! threadA 종료 -> threadB 시작
        sleep(100);
        threadB.start();

        sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
