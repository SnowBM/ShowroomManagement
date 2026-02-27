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
       /**Là lớp dùng để lưu danh sách xe ra file.Nó nhận vào List<Car> và tên file,
           rồi mở file */
    
        public void save(List<Car> cars, String file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        
        /**Duyệt từng Car trong danh sách,chuyển mỗi Car thành chuỗi (toString()),
          ghi vào file theo từng dòng, sau đó đóng file lại.*/
        
        for (Car c : cars) {
            bw.write(c.toString());
            bw.newLine();
        }
        bw.close();
    }
}
