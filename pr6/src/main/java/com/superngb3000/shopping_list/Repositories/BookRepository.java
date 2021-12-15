package com.superngb3000.shopping_list.Repositories;

import com.superngb3000.shopping_list.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
