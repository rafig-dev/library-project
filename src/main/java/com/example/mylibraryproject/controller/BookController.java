package com.example.mylibraryproject.controller;

import com.example.mylibraryproject.model.entity.Book;
import com.example.mylibraryproject.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation("To create new user")
    @PostMapping(value = "/create")
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @PostMapping(value = "/update")
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @GetMapping(value = "/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping(value = "/books/{id}")
    public Book getById(@PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }
}
