/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import model.Brand;
import java.io.*;
import java.util.List;
/**
 *
 * @author VanHieu
 */
public class BrandRepository {
    public void save(List<Brand> brands, String file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Brand b : brands) {
            bw.write(b.toString());
            bw.newLine();
        }
        bw.close();
    } 
}
