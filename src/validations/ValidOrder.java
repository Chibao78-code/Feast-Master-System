/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validations;

import controllers.CTservice;
import static controllers.CTservice.orderMap;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import models.FeastMenu;
import models.Order;
/**
 *
 * @author zzzdi
 */
public class ValidOrder {

    public static boolean validCustomerCode(String code) {
        boolean isValid;
        if (CTservice.customerMap.containsKey(code)) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }

    public static boolean validSetMenu(String set) {
        set = set.toUpperCase();
        for (FeastMenu menu : CTservice.menuList) {
            if (menu.getCode().equals(set)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validTableNumber(int numb) {
        return 0 < numb;
    }

    public static boolean validDate(String date) {
        boolean isValid;
        if (date.trim().equals("")) {
            return false;
        }
        //
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            Date javaDate = format.parse(date);
            Date currentDate = new Date();
            if (javaDate.after(currentDate)) {
                isValid = true;
            } else {
                isValid = false;
            }
        } catch (ParseException e) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean validOrder(int orderCode, String customerCode, String setCode, String eventDate) {
        boolean isValid = false;
        boolean checked = false;
        if (orderMap.isEmpty()) {
            return true;
        }

        for (Order orderL : orderMap.values()) {
            if (orderL.getOrderId() == orderCode) {
                continue;
            }

            if (orderL.getCustomerCode().equalsIgnoreCase(customerCode)
                    && orderL.getSetMenuCode().equalsIgnoreCase(setCode)
                    && orderL.getEventDate().equals(eventDate)) {
                checked = true;
                break;
            }
        }
        if (!checked) {
            isValid = true;
        }
        return isValid;
    }
}

