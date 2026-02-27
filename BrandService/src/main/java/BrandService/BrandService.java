/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.Brand;
import util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class BrandService {
        private List<Brand> brands = new ArrayList<>();

    public List<Brand> getBrands() {
        return brands;
    }

    public void listBrands() {
        brands.forEach(System.out::println);
    }

    public void addBrand(Brand b) {
        if (findById(b.getBrandId()) != null)
            throw new IllegalArgumentException("Duplicate Brand ID");

        if (ValidationUtil.isBlank(b.getBrandName()) ||
            ValidationUtil.isBlank(b.getSoundBrand()) ||
            !ValidationUtil.isPositive(b.getPrice()))
            throw new IllegalArgumentException("Invalid Brand Data");

        brands.add(b);
    }

    public Brand findById(String id) {
        for (Brand b : brands)
            if (b.getBrandId().equals(id))
                return b;
        return null;
    }

    public void updateBrand(String id, String name, String sound, double price) {
        Brand b = findById(id);
        if (b != null) {
            b.setBrandName(name);
            b.setSoundBrand(sound);
            b.setPrice(price);
        }
    }
}

