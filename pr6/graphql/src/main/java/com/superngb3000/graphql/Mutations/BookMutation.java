package com.superngb3000.graphql.Mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.superngb3000.graphql.Entities.Book;
import org.springframework.stereotype.Component;
import com.superngb3000.graphql.Services.BookService;

@Component
public class BookMutation implements GraphQLMutationResolver {

    private final BookService bookService;

    public BookMutation(BookService bookService) {
        this.bookService = bookService;
    }

    public Book createBook(String name, String genre, String author){
        return bookService.createBook(name, genre, author);
    }
    public Book deleteBook(Long id){
        return bookService.deleteBook(id);
    }
}
