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
    private String carId; // private chỉ có class mới có thể tương tác được
    private String brandId;
    private String color;
    private String frameId;
    private String engineId;

    public Car(String carId, String brandId, String color, String frameId, String engineId) {
        this.carId = carId; // chỗ này this. là biến của object
        this.brandId = brandId; // còn đằng sau dấu bằng kia là tham số chuyền vào
        this.color = color;  // nhưng mục đích chính khi dùng this. là để phân biệt biến thuộc object với biến cục bộ
        this.frameId = frameId;
        this.engineId = engineId;
    }

    public String getCarId() { return carId; } // vì là bên trên dùng private nên ta cần getter để truy cập vào
    public String getBrandId() { return brandId; }
    public String getColor() { return color; }
    public String getFrameId() { return frameId; }
    public String getEngineId() { return engineId; }

    public void setColor(String color) { this.color = color; } // thêm setter ở đây vì màu sắc xe có thể đổi

    @Override
    public String toString() {
        return carId + "," + brandId + "," + color + "," + frameId + "," + engineId; // tạo hàm có sẵn của Object để khi muốn in println cho nhanh
    }
}
