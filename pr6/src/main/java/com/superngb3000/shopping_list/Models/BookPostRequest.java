package com.superngb3000.shopping_list.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPostRequest {

    private String name;
    private String genre;
    private String author;
}
