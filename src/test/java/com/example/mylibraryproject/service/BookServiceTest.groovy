package com.example.mylibraryproject.service

import com.example.mylibraryproject.model.entity.Book
import com.example.mylibraryproject.model.enums.Genre
import com.example.mylibraryproject.repository.BookRepository
import spock.lang.Specification

class BookServiceTest extends Specification {
    private BookRepository bookRepository = Mock()
    private BookService service = new BookService(bookRepository)

    def "test - create"() {
        given:
        def bookBeforeCreate = Book.builder()
                .name("Dahi")
                .price(12.0)
                .genre(Genre.CLASSIC)
                .author("Teodor Drayzer")
                .build()

        def bookAfterCreate = bookBeforeCreate
        bookAfterCreate.setId(1)

        when:
        def result = service.create(bookBeforeCreate)

        then:
        1 * bookRepository.save(bookBeforeCreate) >> bookAfterCreate
        result == bookAfterCreate
        noExceptionThrown()
    }

    def "test - update"() {
        given:
        def bookBeforeUpdate = Book.builder()
                .id(1)
                .name("Dahi")
                .price(12.0)
                .genre(Genre.CLASSIC)
                .author("Teodor Drayzer")
                .build()

        def bookAfterUpdate = bookBeforeUpdate

        when:
        def result = service.update(bookBeforeUpdate)

        then:
        1 * bookRepository.save(bookBeforeUpdate) >> bookAfterUpdate
        result == bookAfterUpdate
        noExceptionThrown()
    }

    def "test - getAll"() {
        given:
        List<Book> all = new ArrayList<>()
        all.add(Book.builder()
                .id(1)
                .name("Dahi")
                .price(12.0)
                .genre(Genre.CLASSIC)
                .author("Teodor Drayzer")
                .build())

        when:
        def result = service.getAll()

        then:
        1 * bookRepository.findAll() >> all
        result == all
        noExceptionThrown()
    }

    def "test - getById"() {
        given:
        List<Book> all = new ArrayList<>()
        all.add(Book.builder()
                .id(1)
                .name("Dahi")
                .price(12.0)
                .genre(Genre.CLASSIC)
                .author("Teodor Drayzer")
                .build())

        def book = all.get(0)

        when:
        def result = service.getById(1)

        then:
        1 * bookRepository.findById(1) >> Optional.of(book)
        result == book
    }

    def "test - deleteById"() {
        given:
        def id = 1

        when:
        service.deleteById(id)

        then:
        1 * bookRepository.deleteById(id)
        noExceptionThrown()
    }
}
