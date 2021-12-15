package com.superngb3000.shopping_list.Mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.superngb3000.shopping_list.Entities.Book;
import com.superngb3000.shopping_list.Services.BookService;

import org.springframework.stereotype.Component;

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
