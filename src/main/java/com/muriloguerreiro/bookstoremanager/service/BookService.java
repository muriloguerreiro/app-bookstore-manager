package com.muriloguerreiro.bookstoremanager.service;

import com.muriloguerreiro.bookstoremanager.dto.BookDTO;
import com.muriloguerreiro.bookstoremanager.dto.MessageResponseDTO;
import com.muriloguerreiro.bookstoremanager.entity.Book;
import com.muriloguerreiro.bookstoremanager.exception.BookNotFoundException;
import com.muriloguerreiro.bookstoremanager.mapper.BookMapper;
import com.muriloguerreiro.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}
