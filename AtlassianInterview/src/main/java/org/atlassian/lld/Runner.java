package org.atlassian.lld;

import org.atlassian.lld.RateLimitManager;

/**
 * Imagine we are building an application that is used by many different customers.
 * We want to avoid one customer being able to overload the system by sending too many requests, so we enforce a per-customer rate limit.
 * The rate limit is defined as:
 * <p>
 * “Each customer can make X requests per Y seconds”
 * <p>
 * Assuming that customer ID is extracted somehow from the request, implement the following function.
 * <p>
 * // Perform rate limiting logic for provided customer ID. Return true if the
 * // request is allowed, and false if it is not.
 * boolean rateLimit(int customerId)
 */
public class Runner {

    public static void main(String args[]) throws InterruptedException {

        System.out.println("Test");
        RateLimitManager rateLimitManager = RateLimitManager.getInstance();


        String customer = "Amit Customer#";
        rateLimitManager.register(customer);

        int rateLimitedCounter = 0;
        for (int i = 0; i < 400; i++) {
            boolean result = rateLimitManager.rateLimit(customer);
            if (result) {
                rateLimitedCounter++;
                System.out.println("RateLimited at #" + i);
            }
        }

        System.out.println("TestEnded with # "+rateLimitedCounter+ " ratelimited Requets");
    }
}
// Main Manager Class -> Come for limit validation - Singleton
// Actual Logic (Swapl)-> Interface and 1 Impl
// Reject Flow -> Code Too_many_Request->true

// CustomerId -> Ratelimit.rateLimit(CustomerId)

