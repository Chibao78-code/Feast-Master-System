/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

//models
import models.Customer;
import models.FeastMenu;
import models.Order;
//
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.EOFException;

/**
 *
 * @author zzzdi
 */
public class FileUtils {
    
    /*
    public static void createFileIfNotExist(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                System.out.println("File create successfully: " + path);
            }
        } catch (IOException e) {
            System.out.println("Error when create file: " + e.getMessage());
        }
    }
    */

    public static HashMap<String, Customer> readCustomerFromFile(String path) throws IOException, ClassNotFoundException {
        //createFileIfNotExist(path);
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File not exist: " + path);
            return new HashMap<>();
        }

        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (HashMap<String, Customer>) ois.readObject();
        } catch (EOFException e) {
            return new HashMap<>();
        } catch (IOException e) {
            System.out.println("Error when reading file (readStudentFromFile() method): " + e.getMessage());
            throw e;
        }
    }

    public static boolean writeCustomerToFile(String path, HashMap<String, Customer> customers) {
        try (FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Unexpected error at writeCustomerToFile() " +e.getMessage());
            return false;
        }
        return true;
    }
    
    public static HashMap<Integer, Order> readOrderFromFile(String path) throws IOException, ClassNotFoundException {
        //createFileIfNotExist(path);
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File not exist: " + path);
            return new HashMap<>();
        }

        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (HashMap<Integer, Order>) ois.readObject();
        } catch (EOFException e) {
            return new HashMap<>();
        } catch (IOException e) {
            System.out.println("Error when reading file (readStudentFromFile() method): " + e.getMessage());
            throw e;
        }
    }

    public static boolean writeOrderToFile(String path, HashMap<Integer, Order> orders) {
        try (FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(orders);
        } catch (IOException e) {
            System.out.println("Unexpected error at writeOrderToFile(): " +e.getMessage());
            return false;
        }
        return true;
    }
    


    public static List<FeastMenu> readFeastMenuFromFile(String path) {
        List<FeastMenu> menuList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String firstLine = br.readLine(); //Bo qua dong tieu de dau tien
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 4);
                if (data.length < 4) {
                    continue;
                }

                String code = data[0].trim();
                String name = data[1].trim();
                double price;
                try {
                    price = Double.parseDouble(data[2].trim());
                } catch (NumberFormatException e) {
                    price = 0.0;
                    System.out.println("Errotr at readFeastMenu: " + e);
                }
                String ingredients = data[3].substring(1, data[3].length() - 1).trim();
                //Tach mon an 
                String appetizer = "Không có.", mainCourse = "Không có.", dessert = "Không có.";
                for (String part : ingredients.split("\\#\\+")) {
                    if (part.contains("Khai vị:")) {
                        appetizer = part.replace("+ Khai vị: ", "").trim();
                    } else if (part.contains("Món chính:")) {
                        mainCourse = part.replace("Món chính:", "").trim();
                    } else if (part.contains("Tráng miệng:")) {
                        dessert = part.replace("Tráng miệng:", "").trim();
                    }
                }

                menuList.add(new FeastMenu(code, name, price, appetizer, mainCourse, dessert));
            }
        } catch (IOException e) {
            System.out.println("Unexpected error when read menu from file: " + e.getMessage());
        }

        return menuList;
    }
}
