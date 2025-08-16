/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author zzzdi
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private String phoneNumber;
    private String email;

    public Customer() {
    }

    public Customer(String code, String name, String phoneNumber, String email) {
        this.code = code;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code.toUpperCase();
    }

    public String getName() {
        if (name == null || name.isEmpty()) {
            return "";
        }

        int lastSpaceIndex = name.lastIndexOf(" ");

        if (lastSpaceIndex == -1) {
            return name;
        }

        String lastName = name.substring(lastSpaceIndex + 1);
        String firstMiddleName = name.substring(0, lastSpaceIndex);

        return lastName + ", " + firstMiddleName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer customer = (Customer) obj;
        return Objects.equals(code, customer.code)
                && Objects.equals(name, customer.name)
                && Objects.equals(phoneNumber, customer.phoneNumber)
                && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, phoneNumber, email);
    }

}
