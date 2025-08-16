/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author zzzdi
 */
public class Menu {
    private static final List<String> mainMenu = new ArrayList<>();
    
    static {
        mainMenu.add("||======================================================||");
        mainMenu.add("|| 1. Register customers.                               ||");
        mainMenu.add("|| 2. Update customer information.                      ||");
        mainMenu.add("|| 3. Search for customer information by name.          ||");
        mainMenu.add("|| 4. Display feast menus.                              ||");
        mainMenu.add("|| 5. Place a feast order.                              ||");
        mainMenu.add("|| 6. Update order information.                         ||");
        mainMenu.add("|| 7. Save data to file.                                ||");
        mainMenu.add("|| 8. Display Customer or Order lists.                  ||");
        mainMenu.add("|| Others - Quit.                                       ||");
        mainMenu.add("||======================================================||");
    }
    
    public static List<String> getMainMenu(){
        return mainMenu;
    }
}
