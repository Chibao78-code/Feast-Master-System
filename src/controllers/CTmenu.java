/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import utils.InputUtils;
import views.Menu;
import views.ShowContent;
/**
 *
 * @author zzzdi
 */
public class CTmenu {
    public static void showMenu(){
        for (String menuItem : Menu.getMainMenu()){
            System.out.println(menuItem);
        }
    }
    
    public static int getChoice(String text, int min, int max){
        int option;
        do {
            option = InputUtils.getInt(text);
            if(option < min || max <option){
                ShowContent.warnError("choice");
            }
        } while (option < min || max < option);
        return option;
    }
}
