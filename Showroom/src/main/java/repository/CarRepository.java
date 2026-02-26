/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author hoanganh
 */
import model.Car;
import java.io.*;
import java.util.List;
public class CarRepository {
        public void save(List<Car> cars, String file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Car c : cars) {
            bw.write(c.toString());
            bw.newLine();
        }
        bw.close();
    }
}
