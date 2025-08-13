/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import controllers.CTmenu;
import controllers.CTservice;
import java.io.IOException;
import models.Functions;
import utils.InputUtils;

/**
 *
 * @author zzzdi
 */
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Functions menu = new CTservice();
        int choice;
        boolean exit = false;
        do {
            CTmenu.showMenu();
            choice = InputUtils.getInt("Enter your option: ");
            switch (choice) {
                case 1:
                    ShowContent.reportSuccessOrFailure(menu.registerCustomer(), 1);
                    break;
                case 2:
                    ShowContent.reportSuccessOrFailure(menu.updateCustomer(), 1);
                    break;
                case 3:
                    ShowContent.displayCustomers(menu.searchCustomerByName(), 3);
                    break;
                case 4:
                    menu.showFeastMenu();
                    break;
                case 5:
                    ShowContent.reportSuccessOrFailure(menu.orderFeast(), 5);
                    break;
                case 6:
                    ShowContent.reportSuccessOrFailure(menu.updateOrder(), 6);
                    break;
                case 7:
                    ShowContent.reportSuccessOrFailure(menu.saveData(), 7);
                    break;
                case 8:
                    menu.displayCustormAndOrder();
                    break;
                default:
                    menu.quitProgram();
                    break;
            }
        } while (!exit);
    }
}
