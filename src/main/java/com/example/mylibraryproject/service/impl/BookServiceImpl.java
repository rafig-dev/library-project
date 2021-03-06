package com.example.mylibraryproject.service.impl;

import com.example.mylibraryproject.model.entity.Book;
import com.example.mylibraryproject.repository.BookRepository;
import com.example.mylibraryproject.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book update(@RequestBody Book book) {
        if (book.getId() != null) {
            bookRepository.save(book);
        }
        return book;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
