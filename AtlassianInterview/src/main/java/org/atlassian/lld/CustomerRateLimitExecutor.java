package org.atlassian.lld;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerRateLimitExecutor implements RateLimitExecutor{
    LocalDateTime startTime = LocalDateTime.now();
    AtomicInteger requestCounter;
    private int threshold;
    private int timeBucketSecs;

    public CustomerRateLimitExecutor(int thresold, int timeBucketSecs) {
        this.threshold = thresold;
        this.timeBucketSecs = timeBucketSecs;
        requestCounter = new AtomicInteger(0);
    }

    public boolean rateLimit() {

        LocalDateTime current = LocalDateTime.now();
        long diff = Duration.between(startTime, current).getSeconds();
        if (diff > timeBucketSecs) {
            startTime = LocalDateTime.now();
            requestCounter.set(1);
            return false;
        }
        return threshold < requestCounter.incrementAndGet();
    }

}
