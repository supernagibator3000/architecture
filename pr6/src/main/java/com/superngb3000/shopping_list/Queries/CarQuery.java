package com.superngb3000.shopping_list.Queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.superngb3000.shopping_list.Entities.Car;
import com.superngb3000.shopping_list.Services.CarService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarQuery implements GraphQLQueryResolver {

    private final CarService carService;

    public CarQuery(CarService carService) {
        this.carService = carService;
    }

    public List<Car> getCars(Integer count){
        return carService.getAllCars(count);
    }

    public Optional<Car> getCar(Long id){
        return carService.getCar(id);
    }
}
