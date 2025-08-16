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
public class CTservice implements Functions {

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

    //========================FUN_1: Register Customer========================//    
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

    //=====================FUN_5: Place a feast order=========================//
    @Override
    public boolean orderFeast() {
        Order order = new Order();
        String customerCode = null;
        String setCode;
        int tableNumber;
        String eventDate;
        int orderID;
        double totalCost = 0;
        boolean duplicateOrder = true;
        boolean isSuccess = false;

        //Enter customer code
        customerCode = validCustomerToOrder("register", customerCode);
        if (customerCode == null) {
            return false;
        }
        //Enter set feast code
        setCode = getValidInput("Enter code of set menu: ", ValidOrder::validSetMenu, "set menu code");
        setCode = setCode.toUpperCase();
        //Enter number of tables
        tableNumber = getValidInt("Enter number of table: ", ValidOrder::validTableNumber, "number of table");
        //Enter date of event
        eventDate = getValidInput("Enter event date: ", ValidOrder::validDate, "event date");

        //Check duplicate of oder
        if (ValidOrder.validOrder(0, customerCode, setCode, eventDate)) {
            duplicateOrder = false;
        }
        //If not duplicate order
        if (!duplicateOrder) {
            //Return price of set menu
            for (FeastMenu menu : menuList) {
                if (menu.getCode().equals(setCode)) {
                    totalCost = tableNumber * menu.getPrice();
                    break;
                }
            }
            orderID = orderMap.size() + 1;
            order.setOrderId(orderID);
            order.setCustomerCode(customerCode);
            order.setSetMenuCode(setCode);
            order.setTableNumber(tableNumber);
            order.setEventDate(eventDate);
            order.setTotalCost(totalCost);
            ShowContent.displayOrders(order);
            isSuccess = true;
        }
        orderMap.put(order.getOrderId(), order);
        return isSuccess;
    }

    //====================FUN_6: Update Order Information=====================//
    @Override
    public boolean updateOrder() {
        boolean isSuccess = false;
        boolean duplicateOrder = true;
        int orderCode;
        String setCode;
        int tableNumber;
        double totalCost = 0;
        String eventDate;

        do {
            orderCode = InputUtils.getInt("Enter order code you want to update: ");
            if (orderMap.containsKey(orderCode)) {
                break;
            }
            String conf = InputUtils.getString("This order does not exist. Do you want to try another order code? (Y/N):");
            if (conf.equalsIgnoreCase("N")) {
                return false;
            }
        } while (true);

        //Start update
        Order order = orderMap.get(orderCode);
        //Enter set feast code
        setCode = order.getSetMenuCode();
        while (true) {
            String newSetCode = InputUtils.getString("Enter code of set menu (leave blank to keep current): ").trim();

            if (newSetCode.isEmpty()) {
                break;
            }

            if (ValidOrder.validSetMenu(newSetCode)) {
                setCode = newSetCode.toUpperCase();
                break;
            } else {
                ShowContent.warnError("set menu code");
            }
        }
        //Enter number of tables
        tableNumber = order.getTableNumber();
        while (true) {
            String newTableNumber = InputUtils.getString("Enter number of table (leave blank to keep current): ").trim();
            if (newTableNumber.isEmpty()) {
                break;
            }
            try {
                int parsedTableNumber = Integer.parseInt(newTableNumber);
                if (ValidOrder.validTableNumber(parsedTableNumber)) {
                    tableNumber = parsedTableNumber;
                    break;
                } else {
                    ShowContent.warnError("number of table");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        //Enter date of event
        eventDate = order.getEventDate();
        while (true) {
            String newEventDate = InputUtils.getString("Enter event date (leave blank to keep current): ").trim();
            if (newEventDate.isEmpty()) {
                break;
            }

            if (ValidOrder.validDate(newEventDate)) {
                eventDate = newEventDate;
                break;
            } else {
                ShowContent.warnError("event date");
            }
        }

        //Check duplicate of oder
        if (ValidOrder.validOrder(orderCode, order.getCustomerCode(), setCode, eventDate)) {
            duplicateOrder = false;
        }
        //If not duplicate order
        if (!duplicateOrder) {
            //Return price of set menu
            for (FeastMenu menu : menuList) {
                if (menu.getCode().equals(setCode)) {
                    totalCost = tableNumber * menu.getPrice();
                    break;
                }
            }
            order.setSetMenuCode(setCode);
            order.setTableNumber(tableNumber);
            order.setEventDate(eventDate);
            order.setTotalCost(totalCost);
            ShowContent.displayOrders(order);
            isSuccess = true;
        }
        orderMap.replace(order.getOrderId(), order);
        return isSuccess;
    }

    //======================FUN_7: Save Date to File==========================//
    @Override
    public boolean saveData(){
        boolean isSuccess;
        if (FileUtils.writeCustomerToFile(CUSTOMERS_PATH, customerMap) && FileUtils.writeOrderToFile(FEAST_ORDER_PATH, orderMap)) {
            isSuccess = true;
        } else {
            isSuccess = false;
        }
        return isSuccess;
    }

    //================FUN_8: Display Customer or Order lists==================//
    @Override
    public void displayCustormAndOrder() {
        int choice = CTmenu.getChoice("Enter 1 to display the customer list, 2 to display the order list: ", 1, 2);
        if (choice == 1) {
            if (customerMap.isEmpty()) {
                System.out.println("Customers list is empty!");
                return;
            }
            System.out.println(FRAME_MID);
            System.out.printf("%-8s | %-20s | %-13s | %-25s \n", "Code", "Customer Name", "Phone", "Email");
            System.out.println(FRAME_MID);
            for (Customer customer : customerMap.values()) {
                System.out.printf("%-8s | %-20s | %-13s | %-25s \n", customer.getCode(), customer.getName(), customer.getPhoneNumber(), customer.getEmail());
            }
            System.out.println(FRAME_MID);
        } else if (choice == 2) {
            if (orderMap.isEmpty()) {
                System.out.println("Orders list is empty!");
                return;
            }
            System.out.println(FRAME_PRO);
            System.out.printf("%-2s | %-11s | %-12s | %-9s | %-10s | %-6s | %-15s \n",
                    "ID", "Event Date", "Customer ID", "Set Menu", "Price", "Table", "Cost");
            System.out.println(FRAME_PRO);
            for (Order order : orderMap.values()) {
                System.out.printf("%-2s | %-11s | %-12s | %-9s | %,-10.0f | %-6s | %,-15.0f \n",
                        order.getOrderId(), order.getEventDate(), order.getCustomerCode(), order.getSetMenuCode(),
                        (order.getTotalCost() / order.getTableNumber()), order.getTableNumber(), order.getTotalCost());
            }
            System.out.println(FRAME_PRO);
        }
    }

    //=========================FUN_9: Quit Program============================//
    @Override
    public void quitProgram() throws IOException, ClassNotFoundException {
        HashMap<String, Customer> dataC = FileUtils.readCustomerFromFile(CUSTOMERS_PATH);
        HashMap<Integer, Order> dataO = FileUtils.readOrderFromFile(FEAST_ORDER_PATH);
        
        String confirm = InputUtils.getString("Do you want to exit program(Y/N): ");
        if (confirm.equalsIgnoreCase("Y")) {
            if (!dataC.equals(customerMap) || !dataO.equals(orderMap)) {
                confirm = InputUtils.getString("Do you want to save data before exit program(Y/N): ");
                if (confirm.equalsIgnoreCase("Y")) {
                    saveData();
                }
            }
            System.out.println("Exitting...");
            exit(0);
        } else {
            System.out.println("Cancel exit program!!!");
        }
    }

    //******************SUB-FUNC: Get Valid String Input**********************//
    /**
     * Input method and validation
     *
     * @param message Input message
     * @param validator Validation function
     * @param fieldName Field name to display on error
     * @return Valid value entered by user
     */
    private String getValidInput(String text, Predicate<String> validator, String fieldName) {
        String input;
        do {
            input = InputUtils.getString(text).trim();
            if (validator.test(input)) {
                return input;
            }
            ShowContent.warnError(fieldName);
        } while (true);
    }

    //*****************SUB-FUNC: Get valid Integer Input**********************//
    private int getValidInt(String text, Predicate<Integer> validator, String fieldName) {
        int numb;
        do {
            numb = InputUtils.getInt(text);
            if (validator.test(numb)) {
                return numb;
            }
            ShowContent.warnError(fieldName);
        } while (true);
    }

    //*****************SUB-FUNC: Check customerCode for order*****************//
    private String validCustomerToOrder(String text, String customerCode) {
        do {
            customerCode = getValidInput("Enter customer code: ", ValidCustomer::validCode, "customer code");
            if (ValidOrder.validCustomerCode(customerCode)) {
                return customerCode;
            } else {
                System.out.println("Customer has not registered information!!!");
                String confirm = InputUtils.getString("Do you want to continue " + text + "?(Y/N):").trim();
                if (confirm.equalsIgnoreCase("N")) {
                    return null;
                }
            }
        } while (true);
    }
}

    

