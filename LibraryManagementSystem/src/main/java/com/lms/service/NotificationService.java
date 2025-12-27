package com.lms.service;

import com.lms.domain.BookItem;
import com.lms.domain.Member;
import com.lms.observer.EmailNotificationObserver;
import com.lms.observer.NotificationObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to manage notifications to users.
 */

@Service
public class NotificationService {
    private final List<NotificationObserver> observers = new ArrayList<>();

    public NotificationService(List<NotificationObserver> observers) {
        this.observers.add(new EmailNotificationObserver());
    }

    /** Notify all registered users with a message */

    public void notify(Member member, BookItem bookItem, String message) {
        for (NotificationObserver observer : observers) {
            observer.notify(member,bookItem, message);
        }
    }
}
