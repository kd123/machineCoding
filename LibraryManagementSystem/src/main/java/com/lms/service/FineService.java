package com.lms.service;

import com.lms.domain.Loan;
import com.lms.strategy.FineStrategy;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
public class FineService {
    private final FineStrategy fineStrategy;

    public FineService(FineStrategy fineStrategy) {
        this.fineStrategy = fineStrategy;
    }

    public double calculateFine(Loan loan) {
        if (!loan.isOverdue()) return 0;
        long days = ChronoUnit.DAYS.between(loan.getDueDate(), loan.getReturnDate());
        return fineStrategy.calculateFine(days);
    }
}
