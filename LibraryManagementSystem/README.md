# Library Management System

A Spring Boot–based Library Management System implementing a complete Low-Level Design (LLD) using object-oriented principles and well-known design patterns.  
The system supports book management, member management, book issuing/returning, fine calculation, notifications, and concurrency-safe operations.

---

## Table of Contents

1. Overview
2. Functional Requirements
3. Non-Functional Requirements
4. System Architecture
5. Project Structure
6. Domain Model
7. Design Patterns
8. Concurrency Handling
9. Transaction Management
10. REST APIs
11. Error Handling
12. How to Run
13. Future Enhancements

---

## 1. Overview

The Library Management System is designed to manage physical books in a library environment.  
It ensures strong consistency during book issue/return operations and follows clean architectural principles suitable for production and interview scenarios.

---

## 2. Functional Requirements

- Add and manage books
- Add and manage members
- Issue a book to a member
- Return a book
- Track book loans
- Calculate fine for overdue returns
- Notify users on important events

---

## 3. Non-Functional Requirements

- Strong consistency
- Concurrency safety
- Scalability
- Maintainability
- Extensibility
- Clean separation of concerns

---

## 4. System Architecture

Controller Layer
↓
Service Layer (Facade, Transactions, Concurrency Control)
↓
Template Method Layer (Book Transactions)
↓
Strategy Layer (Fine Calculation)
↓
Repository Layer (JPA)
↓
Database

---

## 5. Project Structure

library-management-system

- controller
  - BookController.java
  - MemberController.java
  - LoanController.java
- domain
  - Book.java
  - BookItem.java
  - Member.java
  - Loan.java
- enums
  - BookStatus.java
  - AccountStatus.java
- factory
  - BookFactory.java
  - BookType.java
- observer
  - NotificationObserver.java
  - EmailNotificationObserver.java
  - NotificationService.java
- repository
  - BookRepository.java
  - MemberRepository.java
  - LoanRepository.java
- service
  - LibraryService.java
  - FineService.java
  - NotificationService.java
  - BookService.java
  - MemberService.java
- strategy
  - FineStrategy.java
  - DefaultFineStrategy.java
- template
  - BookTransactionTemplate.java
  - IssueBookTransaction.java
  - ReturnBookTransaction.java
- LibraryManagementApplication.java

---

## 6. Domain Model

- **Book**: Logical representation of a book (title, author, ISBN)
- **BookItem**: Physical copy of a book
- **Member**: Library user
- **Loan**: Represents an issued book with issue and return dates

---

## 7. Design Patterns

### 7.1 Singleton
- Implemented using Spring’s default bean scope
- Ensures single instance of service components

### 7.2 Factory
- Used to create `BookItem` instances
- Centralizes object creation logic

### 7.3 Strategy
- Used for fine calculation
- Allows multiple fine calculation algorithms

### 7.4 Template Method
- Used for book transactions (issue, return, reserve)
- Defines fixed workflow with customizable steps

### 7.5 Observer
- Used for notification handling
- Decouples notification logic from business logic

### 7.6 Repository
- Encapsulates persistence logic using Spring Data JPA

---

## 8. Concurrency Handling

Concurrency issues are handled at the database level using pessimistic locking.

@Lock(LockModeType.PESSIMISTIC_WRITE)
Optional<BookItem> findByIdForUpdate(Long id);


This ensures that only one transaction can issue or return a specific book at a time, preventing double issuance.

---

## 9. Transaction Management

- Service layer methods are annotated with `@Transactional`
- Guarantees atomicity and consistency
- Automatic rollback on failures

---

## 10. REST APIs

### Add Book
POST /books


### Add Member
POST /members

shell
Copy code

### Issue Book
POST /loans/issue?bookId={bookId}&memberId={memberId}

shell
Copy code

### Return Book
POST /loans/return?bookId={bookId}


---

## 11. Error Handling

- Book not available for issue
- Book not issued while returning
- Invalid book or member ID
- Concurrent modification attempts

---

## 12. How to Run

### Prerequisites
- Java 17+
- Maven
- MySQL or H2 Database

### Steps
mvn clean install
mvn spring-boot:run
The application will start on `http://localhost:8080`.

---

## 13. Future Enhancements

- Book reservation expiry
- Digital books
- Kafka-based notification system
- Redis-based distributed locking
- Elasticsearch for search
- Role-based access control
- Admin reporting dashboard