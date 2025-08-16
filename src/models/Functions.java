/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author zzzdi
 */
public interface Functions {
    boolean registerCustomer();
    boolean updateCustomer();
    List<Customer> searchCustomerByName();
    void showFeastMenu();
    boolean orderFeast();
    boolean updateOrder();
    boolean saveData();
    void displayCustomerAndOrder();
    void quitProgram() throws IOException, ClassNotFoundException;

    public void displayCustormAndOrder();
}
