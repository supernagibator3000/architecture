package com.superngb3000.graphql.Queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.superngb3000.graphql.Entities.Book;
import org.springframework.stereotype.Component;
import com.superngb3000.graphql.Services.BookService;

import java.util.List;
import java.util.Optional;

@Component
public class BookQuery implements GraphQLQueryResolver {

    private final BookService bookService;

    public BookQuery(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getBooks(Integer count){
        return bookService.getAllBooks(count);
    }

    public Optional<Book> getBook(Long id){
        return bookService.getBook(id);
    }
}
