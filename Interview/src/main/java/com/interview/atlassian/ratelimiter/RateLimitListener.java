package com.interview.atlassian.ratelimiter;

public interface RateLimitListener {

    public void rateLimitThresholdBreached();
}
