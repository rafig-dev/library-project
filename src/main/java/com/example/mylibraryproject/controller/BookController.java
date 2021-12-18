package com.example.mylibraryproject.controller;

import com.example.mylibraryproject.model.dto.BookDTO;
import com.example.mylibraryproject.model.entity.Book;
import com.example.mylibraryproject.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @GetMapping
    public List<BookDTO> getAll() {
        return bookService.getAll();
    }

    @GetMapping(value = "{id}")
    public Book getById(@PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }
}
