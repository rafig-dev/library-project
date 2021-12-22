package com.example.mylibraryproject.service;

import com.example.mylibraryproject.model.entity.Book;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookService {
    Book create(@RequestBody Book book);

    Book update(@RequestBody Book book);

    List<Book> getAll();

    Book getById(Integer id);

    void deleteById(Integer id);
}
