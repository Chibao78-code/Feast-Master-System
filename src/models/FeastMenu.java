/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author zzzdi
 */
public class FeastMenu {
    private String code;
    private String name;
    private double price;
    private String appetizer;
    private String mainCourse;
    private String dessert;

    public FeastMenu() {
    }
    public FeastMenu(String code, String name, double price, String appetizer, String mainCourse, String dessert) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.appetizer = appetizer;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
    }

    public FeastMenu(String code, String name, String price, String appetizer, String mainCourse, String dessert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getAppetizer() {
        return appetizer;
    }
    public void setAppetizer(String appetizer) {
        this.appetizer = appetizer;
    }

    public String getMainCourse() {
        return mainCourse;
    }
    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public String getDessert() {
        return dessert;
    }
    public void setDessert(String dessert) {
        this.dessert = dessert;
    }
}
