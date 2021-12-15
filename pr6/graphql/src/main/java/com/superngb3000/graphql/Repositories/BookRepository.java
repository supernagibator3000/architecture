package com.superngb3000.graphql.Repositories;

import com.superngb3000.graphql.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
