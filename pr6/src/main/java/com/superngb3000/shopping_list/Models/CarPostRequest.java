package com.superngb3000.shopping_list.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarPostRequest {

    private String title;
    private String brand;
    private Integer price;
    private Integer age;
}
