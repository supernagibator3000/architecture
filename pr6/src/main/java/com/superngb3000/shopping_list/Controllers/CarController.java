package com.superngb3000.shopping_list.Controllers;

import com.superngb3000.shopping_list.Entities.Car;
import com.superngb3000.shopping_list.Models.CarPostRequest;
import com.superngb3000.shopping_list.Mutations.CarMutation;
import com.superngb3000.shopping_list.Queries.CarQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarQuery carQuery;
    private final CarMutation carMutation;

    public CarController(CarQuery carQuery, CarMutation carMutation) {
        this.carQuery = carQuery;
        this.carMutation = carMutation;
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return carQuery.getCars(10);
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable Long id){
        return carQuery.getCar(id).orElse(null);
    }

    @PostMapping("/car")
    public Car create(@RequestBody CarPostRequest carPostRequest){
        return carMutation.createCar(carPostRequest.getTitle(),
                carPostRequest.getBrand(),
                carPostRequest.getPrice(),
                carPostRequest.getAge());
    }

    @DeleteMapping("/car/{id}")
    public Car delete(@PathVariable Long id){
        return carMutation.deleteCar(id);
    }
}
