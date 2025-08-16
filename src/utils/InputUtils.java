/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author zzzdi
 */
public class InputUtils {

    public static int getInt(String text) {
        int number;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print(text);
            number = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            number = -1;
        }
        return number;
    }

    public static String getString(String text) {
        String input = null;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print(text);
            input = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Error while using getString(): " + e.getMessage());
        }
        return input;
    }
}
