/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoanganh
 */
import java.io.Serializable;

public class Car implements Comparable, Serializable { 
    private String carID;
 private Brand brand; 
private String color; 
private String frameID; 
private String engineID;
public Car() {}

public Car(String carID, Brand brand, String color, String frameID, String engineID) {
    this.carID = carID;
    this.brand = brand;
    this.color = color;
    this.frameID = frameID;
    this.engineID = engineID;
}

public String getCarID() { return carID; }
public void setCarID(String carID) { this.carID = carID; }

public Brand getBrand() { return brand; }
public void setBrand(Brand brand) { this.brand = brand; }

public String getColor() { return color; }
public void setColor(String color) { this.color = color; }

public String getFrameID() { return frameID; }
public void setFrameID(String frameID) { this.frameID = frameID; }

public String getEngineID() { return engineID; }
public void setEngineID(String engineID) { this.engineID = engineID; }

// sort theo brand name -> carID
@Override
public int compareTo(Car o) {
    int d = this.brand.getBrandName().compareToIgnoreCase(o.brand.getBrandName());
    if (d != 0) return d;
    return this.carID.compareToIgnoreCase(o.carID);
}

// ghi file
@Override
public String toString() {
    return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
}

// hiển thị màn hình
public String screenString() {
    return brand.toString() + "\n" +
           "  - CarID   : " + carID + "\n" +
           "  - Color   : " + color + "\n" +
           "  - FrameID : " + frameID + "\n" +
           "  - EngineID: " + engineID;
}
}