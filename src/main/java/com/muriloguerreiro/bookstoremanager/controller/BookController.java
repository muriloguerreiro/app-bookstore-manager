package com.muriloguerreiro.bookstoremanager.controller;

import com.muriloguerreiro.bookstoremanager.dto.BookDTO;
import com.muriloguerreiro.bookstoremanager.dto.MessageResponseDTO;
import com.muriloguerreiro.bookstoremanager.exception.BookNotFoundException;
import com.muriloguerreiro.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }
}