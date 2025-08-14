/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
//
import models.Customer;
import models.FeastMenu;
import models.Functions;
import models.Order;
import utils.FileUtils;
import utils.InputUtils;
import validations.ValidCustomer;
import validations.ValidOrder;
import views.ShowContent;
import static views.ShowContent.FRAME_MID;
import static views.ShowContent.FRAME_PRO;
/**
 *
 * @author zzzdi
 */
public class CTservice {
     //Link data
    public static final String CUSTOMERS_PATH = "src/datas/Customers.dat";
    public static final String FEAST_ORDER_PATH = "src/datas/Orders.dat";
    public static final String FEAST_PATH = "src/datas/FeastMenu.csv";
    //Read data
    public static final HashMap<String, Customer> customerMap;
    public static final HashMap<Integer, Order> orderMap;
    public static final List<FeastMenu> menuList = FileUtils.readFeastMenuFromFile(FEAST_PATH);
static {
        HashMap<String, Customer> tempMap;
        try {
            tempMap = FileUtils.readCustomerFromFile(CUSTOMERS_PATH);
        } catch (IOException | ClassNotFoundException e) {
            tempMap = new HashMap<>();
            System.out.println("Error loading customer data: " + e.getMessage());
        }
        customerMap = tempMap;
    }

    static {
        HashMap<Integer, Order> tempMap;
        try {
            tempMap = FileUtils.readOrderFromFile(FEAST_ORDER_PATH);

        } catch (IOException | ClassNotFoundException e) {
            tempMap = new HashMap<>();
            System.out.println("Error loading customer data: " + e.getMessage());
        }
        orderMap = tempMap;
    }
    @Override
    public boolean registerCustomer() {
        Customer customer = new Customer();
        String code;
        String name;
        String phoneNumber;
        String email;
        //Enter customer code
        do {
            code = getValidInput("Enter customer's code: ", ValidCustomer::validCode, "customer's code");
            if (!customerMap.containsKey(code)) {
                break;
            } else {
                String conf = InputUtils.getString("This customer code already exists! Do you want to cancel proceed? (Y/N): ");
                if (conf.equalsIgnoreCase("Y")) {
                    return false;
                }
            }
        } while (true);
    
    
    
}
