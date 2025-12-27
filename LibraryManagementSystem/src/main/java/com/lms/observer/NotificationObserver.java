package com.lms.observer;

import com.lms.domain.BookItem;
import com.lms.domain.Member;

/**
 * Observer interface for notifying users about various events.
 */
public interface NotificationObserver {
    void notify(Member member, BookItem bookItem, String message);
}
