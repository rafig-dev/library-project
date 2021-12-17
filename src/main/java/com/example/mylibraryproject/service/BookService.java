package com.example.mylibraryproject.service;

import com.example.mylibraryproject.model.entity.Book;
import com.example.mylibraryproject.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(@RequestBody Book book) {
        bookRepository.save(book);
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
