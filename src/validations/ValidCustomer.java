/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validations;

/**
 *
 * @author zzzdi
 */
public class ValidCustomer {
    public static boolean validCode(String code) {
        if (code.isEmpty()) {
            return false;
        }
        
        boolean isValid = false;
        //Check valid code
        String pattern = "^[CGK][0-9]{4}$";
        if (code.matches(pattern)){
            isValid = true;
        }
        return isValid;
      
}
     public static boolean validName(String name){
        if (name.isEmpty()) {
            return false;
        }
        
        boolean isValid = false;
        //Check valid name
        if (2 < name.length() && name.length() < 25){
            isValid = true;
        }
        return isValid;
    }
}
