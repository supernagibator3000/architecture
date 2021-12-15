package com.superngb3000.shopping_list.Queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.superngb3000.shopping_list.Entities.Book;
import com.superngb3000.shopping_list.Services.BookService;
import org.springframework.stereotype.Component;

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
