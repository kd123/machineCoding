package com.lms.observer;


import com.lms.domain.BookItem;
import com.lms.domain.Member;

/**
 * Concrete observer for sending email notifications to users.
 */
public class EmailNotificationObserver implements NotificationObserver {

    /** Notify user via email */

    @Override
    public void notify(Member member, BookItem bookItem, String message) {
        // Simulate sending an email notification
        System.out.println("Book Item ID: " + bookItem.getId()+ " is " + message + "to member " + member.getName());
    }
}
