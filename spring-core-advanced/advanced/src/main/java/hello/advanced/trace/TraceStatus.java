package hello.advanced.trace;

public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs; // 로그시작시간. 로그 종료시 시작시간을 기준으로 시작~종료할 때 사용
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }
}
