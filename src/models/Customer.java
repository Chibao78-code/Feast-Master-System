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
    
    private static final long seralVersionUID = 1L;
    
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
        this.code = code;
    }

    public String getName() {
        return name;
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
    public String toString() {
        return "Customer{" + "code=" + code + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
    }
    
    
    
}
