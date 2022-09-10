package hello.advanced.trace.threadlocal;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import hello.advanced.trace.threadlocal.code.ThreadLocalLogTraceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();
    private static final ThreadLocal<TraceId> id = ThreadLocal.withInitial(() -> new TraceId());

    @Test
    void begin_end_leve2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_leve2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }

    @Test
    void ThreadLocalTest() {
        TraceId traceId = id.get();
        log.info("traceId = {}", traceId.getId());
    }

}
