package com.lms.strategy;

import org.springframework.stereotype.Component;

/**
 * Default implementation of FineStrategy that calculates fines based on a fixed rate per overdue day.
 */
@Component
public class DefaultFineStrategy implements FineStrategy {

    private static final double FINE_PER_DAY = 5.0; // Default fine rate per day

    /**
     * Calculates the fine based on the number of overdue days.
     *
     * @param overdueDays Number of days the item is overdue.
     * @return The total fine amount.
     */
    @Override
    public double calculateFine(long overdueDays) {
        if (overdueDays <= 0) {
            return 0.0;
        }
        return overdueDays * FINE_PER_DAY;
    }
}
