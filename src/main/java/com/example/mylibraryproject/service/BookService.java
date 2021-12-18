package com.example.mylibraryproject.service;

import com.example.mylibraryproject.model.dto.BookDTO;
import com.example.mylibraryproject.model.entity.Book;
import com.example.mylibraryproject.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

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

    public Book update(@RequestBody Book book) {
        if (book.getId() != null) {
            bookRepository.save(book);
        }
        return book;
    }

    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Book getById(Integer id) {
        return bookRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }


    private BookDTO mapToDTO(Book book) {
        return BookDTO.builder()
                .name(book.getName())
                .genre(book.getGenre())
                .build();
    }
}
