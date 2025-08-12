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
    private String price;
    private String Ingredients;
    private String mainCourse;
    private String dessert;

    public FeastMenu() {
    }

    public FeastMenu(String code, String name, String price, String Ingredients, String mainCourse, String dessert) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.Ingredients = Ingredients;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String Ingredients) {
        this.Ingredients = Ingredients;
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

    @Override
    public String toString() {
        return "FeastMenu{" + "code=" + code + ", name=" + name + ", price=" + price + ", Ingredients=" + Ingredients + ", mainCourse=" + mainCourse + ", dessert=" + dessert + '}';
    }
    
    
    
}
