package com.superngb3000.shopping_list.Services;

import com.superngb3000.shopping_list.Entities.Car;
import com.superngb3000.shopping_list.Repositories.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public Car createCar (String title, String brand, Integer price, Integer age){
        final Car car = new Car();
        car.setTitle(title);
        car.setBrand(brand);
        car.setPrice(price);
        car.setAge(age);
        return carRepository.save(car);
    }

    @Transactional
    public Car deleteCar(Long id){
        Car car = carRepository.findById(id).orElse(null);
        if (car==null) return null;
        carRepository.deleteById(id);
        return car;
    }

    @Transactional(readOnly = true)
    public List<Car> getAllCars(Integer count){
        return carRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Car> getCar(Long id){
        return carRepository.findById(id);
    }
}
