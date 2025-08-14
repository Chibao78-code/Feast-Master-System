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
                //Enter customer name
        name = getValidInput("Enter customer's name: ", ValidCustomer::validName, "customer's name");
        //Enter customer phone
        phoneNumber = getValidInput("Enter customer's phone number: ", ValidCustomer::validPhoneNumber, "customer's phone number");
        //Enter customer email
        email = getValidInput("Enter customer's email: ", ValidCustomer::validEmail, "customer's email");

        //Add customer information
        customer.setCode(code);
        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customerMap.put(customer.getCode(), customer);

        return true;
    }
     //===================FUN_2: Update Customer Information===================//
    @Override
    public boolean updateCustomer() {
        if (customerMap.isEmpty()) {
            ShowContent.reportSuccessOrFailure(false, 2);
            return false;
        }
         String code = null;
        Customer customerUpdate;

        //Check customer code
        code = validCustomerToOrder("update", code);
        customerUpdate = customerMap.get(code);
        if (customerUpdate == null) {
            return false;
        }
         System.out.println("Leave blank to keep the current value.");
         
         //Update Name
        do {
            String newName = InputUtils.getString("Enter new name: ");
            if (newName.isEmpty() || ValidCustomer.validName(newName)) {
                if (!newName.isEmpty()) {
                    customerUpdate.setName(newName);
                }
                break;
            } else {
                ShowContent.warnError("customer's name");
            }
        } while (true);
        //Update Phone number
        do {
            String newPhone = InputUtils.getString("Enter new phone number: ");
            if (newPhone.isEmpty() || ValidCustomer.validPhoneNumber(newPhone)) {
                if (!newPhone.isEmpty()) {
                    customerUpdate.setPhoneNumber(newPhone);
                }
                break;
            } else {
                ShowContent.warnError("customer's phone number");
            }
        } while (true);
        //Update email
        do {
            String newEmail = InputUtils.getString("Enter new email: ");
            if (newEmail.isEmpty() || ValidCustomer.validEmail(newEmail)) {
                if (!newEmail.isEmpty()) {
                    customerUpdate.setEmail(newEmail);
                }
                break;
            } else {
                ShowContent.warnError("customer's email");
            }
        } while (true);

        customerMap.replace(code, customerUpdate);
        return true;
    }
    //===================FUN_3: Search Customers by Name======================//
    @Override
    public List<Customer> searchCustomerByName() {
        String name = InputUtils.getString("Matching Customers: ").toLowerCase();

        List<Customer> matchCustomers = new ArrayList<>();
        for (Customer customer : customerMap.values()) {
            if (customer.getName().toLowerCase().contains(name)) {
                matchCustomers.add(customer);
            }
        }

        return matchCustomers;
    }
    //=====================FUN_4: Display Feast Menus=========================//
    @Override
    public void showFeastMenu() {
        if (menuList.isEmpty()) {
            System.out.println("Cannot read data from feastMenu.csv. Please check it.");
            return;
        }

        menuList.sort(Comparator.comparingDouble(FeastMenu::getPrice));
        System.out.println(FRAME_PRO);
        System.out.println("List of Set Menus for ordering party:");
        System.out.println(FRAME_PRO);
        for (FeastMenu menu : menuList) {
            System.out.println("Code       : " + menu.getCode());
            System.out.println("Set        : " + menu.getName());
            System.out.printf("Price      : %,.0f VND", menu.getPrice());
            System.out.println("\nIngredients: ");
            System.out.println("+ Khai vị: " + menu.getAppetizer());
            System.out.println("+ Món chính: " + menu.getMainCourse());
            System.out.println("+ Tráng miệng: " + menu.getDessert());
            System.out.println(FRAME_PRO);
        }
    }
    
    
}
