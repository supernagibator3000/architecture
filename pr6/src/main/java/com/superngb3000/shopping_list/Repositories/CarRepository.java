package com.superngb3000.shopping_list.Repositories;

import com.superngb3000.shopping_list.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
