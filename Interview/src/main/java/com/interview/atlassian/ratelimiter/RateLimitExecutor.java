package com.interview.atlassian.ratelimiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author aayush
 * This class calculates the TPS and applies the throttling policy
 * It uses granular write locking for thread safety.
 */
public class RateLimitExecutor {
    private TimeUnit timeUnit;          // Defaults to seconds
    private long transactions = 0L;     // Current transactions counted
    private long threshold;             // Transactions per second allowed
    private long tps;                   // Calculated Transactions per second
    private String instance_id;         // Throttle key
    // Timestamp for evaluation
    private double timeStamp;           // Thread Safety aids
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private WriteLock wLock = rwLock.writeLock();
    private RateLimitListener listener; // Callback handle

    public RateLimitExecutor() {
        this.timeStamp = System.currentTimeMillis();
    }

    public void setInstanceID(String instance_id) {
        this.instance_id = instance_id;
    }

    public void evalute() {
        System.out.println("Starting Rate Limit evaluation\n" + "Threshold set is: " + threshold);
        ++transactions;

        wLock.lock();

        long currentTime = System.currentTimeMillis();   // Take the current timestamp
        double deltaTime = (currentTime - timeStamp);    // Get the delta time elapsed
        System.out.println("Delta time elapsed: " + deltaTime);

        tps = (long) (transactions / deltaTime * 1000L); // Calculate transactions per second

        if (transactions != 1) // Don’t print TPS on the very first hit as its misleading
            System.out.println("TPS is — " + tps);

        // What is higher, TPS threshold or transactions per second? Exclude the very first transaction to avoid false positives
        if (tps >= threshold && transactions != 1) {
            System.out.println("Rate limit has been breached, Transaction Number: " + transactions +
                    " in delta time (milliseconds): " + deltaTime +
                    " Threshold: " + threshold);
            RateLimitManager._instance.getThreadPool().execute(new WorkerThread(listener));
        }
// Leave write lock
        wLock.unlock();
    }

    public void build(TimeUnit time, long threshold) {
        this.timeUnit = time;
        this.threshold = threshold;
    }

    public void setListener(RateLimitListener listener) {
        this.listener = listener;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public Long getTransactions() {
        return transactions;
    }

    public long getThreshold() {
        return threshold;
    }

    public String getInstance_id() {
        return instance_id;
    }

    public void setInstance_id(String instance_id) {
        this.instance_id = instance_id;
    }
}