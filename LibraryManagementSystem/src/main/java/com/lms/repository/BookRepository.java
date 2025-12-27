package com.lms.repository;

import com.lms.domain.Book;
import com.lms.domain.BookItem;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<BookItem, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT b FROM BookItem b WHERE b.id = :id")
    Optional<BookItem> findByIdForUpdate(Long id);
}
