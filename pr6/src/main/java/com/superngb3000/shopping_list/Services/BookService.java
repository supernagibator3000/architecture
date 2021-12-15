package com.superngb3000.shopping_list.Services;

import com.superngb3000.shopping_list.Entities.Book;
import com.superngb3000.shopping_list.Repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book createBook (String name, String genre, String author){
        final Book book = new Book();
        book.setName(name);
        book.setGenre(genre);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Transactional
    public Book deleteBook(Long id){
        Book book = bookRepository.findById(id).orElse(null);
        if (book==null) return null;
        bookRepository.deleteById(id);
        return book;
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks(Integer count){
        return bookRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Book> getBook(Long id){
        return bookRepository.findById(id);
    }
}
