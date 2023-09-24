package org.atlassian.lld;

import java.util.HashMap;
import java.util.Map;

public class RateLimitManager {

    private static RateLimitManager instance;
    private int threshold;
    private int timeBucketSecs;

    private RateLimitManager(int threshold, int timeBucketSecs) {
        this.threshold = threshold;
        this.timeBucketSecs = timeBucketSecs;
    }

    public static RateLimitManager getInstance() {
        if (instance == null) {
            instance = new RateLimitManager(50, 1);
        }
        return instance;
    }

    private Map<String, RateLimitExecutor> registeredCustomer = new HashMap<>();

    public boolean rateLimit(String customerId) {
        RateLimitExecutor executor = registeredCustomer.get(customerId);
        if (executor == null) return false;
        return executor.rateLimit();
    }

    public void register(String customerID) {
        registeredCustomer.put(customerID, new CustomerRateLimitExecutor(threshold, timeBucketSecs));
    }
}
