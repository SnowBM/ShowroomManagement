/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author hoanganh
 */
import model.Car; import model.Brand;

import java.util.*;

public class CarRepository {
    private final List<Car> carList = new ArrayList<>();
    private final BrandRepository brandRepository;

public int searchEngine(String engineID) {
    for (int i = 0; i < carList.size(); i++) {
        if (carList.get(i).getEngineID().equalsIgnoreCase(engineID)) return i;
    }
    return -1;
}

public boolean addCar(Car car) {
    if (searchID(car.getCarID()) != -1) return false;
    if (searchFrame(car.getFrameID()) != -1) return false;
    if (searchEngine(car.getEngineID()) != -1) return false;
    carList.add(car);
    return true;
}

public boolean removeCar(String carID) {
    int pos = searchID(carID);
    if (pos == -1) return false;
    carList.remove(pos);
    return true;
}

public boolean updateCar(String carID, Brand brand, String color, String frameID, String engineID) {
    int pos = searchID(carID);
    if (pos == -1) return false;

    // check duplicate frame
    int fPos = searchFrame(frameID);
    if (fPos != -1 && fPos != pos) return false;

    // check duplicate engine
    int ePos = searchEngine(engineID);
    if (ePos != -1 && ePos != pos) return false;

    Car c = carList.get(pos);
    c.setBrand(brand);
    c.setColor(color);
    c.setFrameID(frameID);
    c.setEngineID(engineID);
    return true;
}

public List<Car> getAllSortedByBrandName() {
    List<Car> sorted = new ArrayList<>(carList);
    Collections.sort(sorted);
    return sorted;
}

public List<Car> searchByPartOfBrandName(String key) {
    List<Car> rs = new ArrayList<>();
    for (Car c : carList) {
        if (c.getBrand().getBrandName().toLowerCase().contains(key.toLowerCase())) {
            rs.add(c);
        }
    }
    return rs;
}

public List<Car> getCarList() {
    return carList;
}
}

