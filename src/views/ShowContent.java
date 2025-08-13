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
}
