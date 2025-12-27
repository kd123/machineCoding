package com.lms.strategy;

/**
 * Strategy interface for calculating fines based on overdue days.
 */
public interface FineStrategy {

    double calculateFine(long overdueDays);
}
