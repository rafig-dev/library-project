package com.example.mylibraryproject.controller;

import com.example.mylibraryproject.model.entity.Book;
import com.example.mylibraryproject.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/")
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping(value = "/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping(value = "/books/{id}")
    public Book getById(@PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }
}
