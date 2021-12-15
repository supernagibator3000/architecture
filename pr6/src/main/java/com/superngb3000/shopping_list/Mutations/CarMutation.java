package com.superngb3000.shopping_list.Mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.superngb3000.shopping_list.Entities.Car;
import com.superngb3000.shopping_list.Services.CarService;
import org.springframework.stereotype.Component;

@Component
public class CarMutation implements GraphQLMutationResolver {

    private final CarService carService;

    public CarMutation(CarService carService) {
        this.carService = carService;
    }

    public Car createCar(String title, String brand, Integer price, Integer age){
        return carService.createCar(title, brand, price, age);
    }
    public Car deleteCar(Long id){
        return carService.deleteCar(id);
    }
}
