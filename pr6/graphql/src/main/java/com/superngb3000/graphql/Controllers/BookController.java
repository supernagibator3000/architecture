package com.superngb3000.graphql.Controllers;

import com.superngb3000.graphql.Entities.Book;
import com.superngb3000.graphql.Models.BookPostRequest;
import com.superngb3000.graphql.Mutations.BookMutation;
import com.superngb3000.graphql.Queries.BookQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookQuery bookQuery;
    private final BookMutation bookMutation;

    public BookController(BookQuery bookQuery, BookMutation bookMutation) {
        this.bookQuery = bookQuery;
        this.bookMutation = bookMutation;
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookQuery.getBooks(10);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long id){
        return bookQuery.getBook(id).orElse(null);
    }

    @PostMapping("/book")
    public Book create(@RequestBody BookPostRequest bookPostRequest){
        return bookMutation.createBook(bookPostRequest.getName(),
                bookPostRequest.getGenre(),
                bookPostRequest.getAuthor());
    }

    @DeleteMapping("/book/{id}")
    public Book delete(@PathVariable Long id){
        return bookMutation.deleteBook(id);
    }
}
