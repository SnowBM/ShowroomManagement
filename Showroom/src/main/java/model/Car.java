/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoanganh
 */
public class Car {
    private String carId;
    private String brandId;
    private String color;
    private String frameId;
    private String engineId;

    public Car(String carId, String brandId, String color, String frameId, String engineId) {
        this.carId = carId;
        this.brandId = brandId;
        this.color = color;
        this.frameId = frameId;
        this.engineId = engineId;
    }

    public String getCarId() { return carId; }
    public String getBrandId() { return brandId; }
    public String getColor() { return color; }
    public String getFrameId() { return frameId; }
    public String getEngineId() { return engineId; }

    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        return carId + "," + brandId + "," + color + "," + frameId + "," + engineId;
    }
}
