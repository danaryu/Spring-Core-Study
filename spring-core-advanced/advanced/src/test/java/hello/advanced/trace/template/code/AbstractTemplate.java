package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 부모클래스: 변하지 않는 부분
 */
@Slf4j
public abstract class AbstractTemplate {

    // 변하지 않는 부분에 대한 분리 (하나의 Template화)
    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        call(); // 상속 --> 변하는 부분은 자식 class에서 상속받아 처리하게끔 처리
        // 비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    protected abstract void call();
}
