package com.example.mylibraryproject.repository;

import com.example.mylibraryproject.model.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAll();
}
