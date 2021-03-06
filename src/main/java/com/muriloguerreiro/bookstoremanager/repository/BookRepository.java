package com.muriloguerreiro.bookstoremanager.repository;

import com.muriloguerreiro.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
