/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import static controllers.CTservice.customerMap;
import static controllers.CTservice.menuList;
import java.util.List;
import models.Customer;
import models.FeastMenu;
import models.Order;

/**
 *
 * @author zzzdi
 */
public class ShowContent {
    public static final String FRAME = "----------------------------------------------------------";
    public static final String FRAME_MID = "----------------------------------------------------------------------------";
    public static final String FRAME_PRO = "--------------------------------------------------------------------------------";

    //========================METHOD: Warn Error==============================//
    public static void warnError(String text) {
        System.out.println(FRAME);
        System.out.println("WARNING: Invalid " + text + "!!! Please enter again.");
        System.out.println(FRAME);
    }
    ublic static void reportSuccessOrFailure(boolean stat, int cases) {
        System.out.println(FRAME);
        if (stat) {
            System.out.println("SUCCESS: The operation was completed successfully!");
        } else {
            switch (cases) {
                case 1: {
                    System.out.println("Failure: Process was canceled!!");
                    break;
                }
                case 5: {
                    System.out.println("Failure: This order feast already exist!!!");
                    break;
                }
                case 6: {
                    System.out.println("Failure: This order feast already exist!!!");
                    break;
                }
                case 7: {
                    System.out.println("Failure: Save data successfully.");
                    break;
                }
            }
        }
        System.out.println(FRAME);
    }
    public static void displayCustomers(List<Customer> customers, int numbFunc) {
        if (customers.isEmpty()) {
            System.out.println(FRAME_MID);
            if (numbFunc == 3) {
                System.out.println("No one matches the search criteria! ");
            }
            System.out.println(FRAME_MID);
        } else {
            System.out.println(FRAME_MID);
            System.out.printf("%-8s | %-20s | %-12s | %-25s\n", "Code", "Customer Name", "Phone", "Email");
            System.out.println(FRAME_MID);
            for (Customer customer : customers) {
                System.out.printf("%-8s | %-20s | %-12s | %-25s\n", customer.getCode(), customer.getName(), customer.getPhoneNumber(), customer.getEmail());
            }
            System.out.println(FRAME_MID);
        }
         public static void displayCustomers(List<Customer> customers, int numbFunc) {
        if (customers.isEmpty()) {
            System.out.println(FRAME_MID);
            if (numbFunc == 3) {
                System.out.println("No one matches the search criteria! ");
            }
            System.out.println(FRAME_MID);
        } else {
            System.out.println(FRAME_MID);
            System.out.printf("%-8s | %-20s | %-12s | %-25s\n", "Code", "Customer Name", "Phone", "Email");
            System.out.println(FRAME_MID);
            for (Customer customer : customers) {
                System.out.printf("%-8s | %-20s | %-12s | %-25s\n", customer.getCode(), customer.getName(), customer.getPhoneNumber(), customer.getEmail());
            }
            System.out.println(FRAME_MID);
        }
    }
         public static void displayOrders(Order order) {
        FeastMenu menu = getSetMenu(order.getSetMenuCode());
        Customer customer = customerMap.get(order.getCustomerCode());

        System.out.println(FRAME);
        System.out.println("Customer order information [Order ID : " + order.getOrderId() + "]");
        System.out.println(FRAME);
        System.out.println("Code          :" + customer.getCode());
        System.out.println("Customer name :" + customer.getName());
        System.out.println("Phone number  :" + customer.getPhoneNumber());
        System.out.println("Email         :" + customer.getEmail());
        System.out.println(FRAME);
        System.out.println("Code of Set Menu:" + menu.getCode());
        System.out.println("Set Menu Name   :" + menu.getName());
        System.out.println("Event date      :" + order.getEventDate());
        System.out.println("Number of Tables:" + order.getTableNumber());
        System.out.printf("Price           : %,.0f Vnd\n", menu.getPrice());
        System.out.println("Ingredients:");
        System.out.println("+ Khai vị: " + menu.getAppetizer());
        System.out.println("+ Món chính: " + menu.getMainCourse());
        System.out.println("+ Tráng miệng:" + menu.getDessert());
        System.out.println(FRAME);
        System.out.printf("Total cost: %,.0f Vnd\n", order.getTotalCost());
        System.out.println(FRAME);
    }
         
     public static FeastMenu getSetMenu(String code) {
        for (FeastMenu menu : menuList) {
            if (menu.getCode().equalsIgnoreCase(code)) {
                return menu;
            }
        }
        return null;
    }
}
