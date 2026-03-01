/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.Car;
import util.ValidationUtil;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author admin
 * Update: hungtd
 */
public class CarService {
    Scanner sc = new Scanner (System.in);
    
    private List<Car> cars = new ArrayList<>();
    private BrandService brandService;

    public CarService(BrandService brandService) {
        this.brandService = brandService;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car c) {
        if (brandService.findById(c.getBrandId()) == null){
            throw new IllegalArgumentException("Brand ID not exist");
        }
        for (Car car : cars) {
            if (car.getCarId().equals(c.getCarId()) ||
                car.getFrameId().equals(c.getFrameId()) ||
                car.getEngineId().equals(c.getEngineId()))
                throw new IllegalArgumentException("Duplicate Car ID / Frame / Engine");
        }

        if (ValidationUtil.isBlank(c.getColor()) ||
            !ValidationUtil.matchFrameId(c.getFrameId()) ||
            !ValidationUtil.matchEngineId(c.getEngineId()))
            throw new IllegalArgumentException("Invalid Car Data");

        
        
        cars.add(c);
    }

    public void updateCar (Car c){
        for (Car car: cars){
            if (car.getCarId().equals (c.getCarId())){
                System.out.println("Which part do you want to update?");
                System.out.println("1. Brand ID");
                System.out.println("2. Color");
                System.out.println("3. Frame ID");
                System.out.println("4. Engine ID");
                System.out.print ("Your choice: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        car.setBrandId ();
                        break;
                    case 2:
                        car.setColor();
                        break;
                    case 3:
                        car.setFrameId ();
                        break;
                    case 4:
                        car.setEngineId ();
                        break;
                }
            }
        }
    }

    public void removeCar(String id) {
        cars.removeIf(c -> c.getCarId().equals(id));
    }

    public void listCarsSortedByBrandName() {
        cars.sort(Comparator.comparing(c ->
            brandService.findById(c.getBrandId()).getBrandName()
        ));
        cars.forEach(System.out::println);
    }

    public void searchByBrandName(String keyword) {
        cars.stream()
            .filter(c -> brandService.findById(c.getBrandId())
                    .getBrandName().toLowerCase().contains(keyword.toLowerCase()))
            .forEach(System.out::println);
    }
}

