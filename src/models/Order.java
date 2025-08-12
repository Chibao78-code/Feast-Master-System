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
public class Order implements Serializable {
    
    private static final long serialVersionUID = 10L;
    
    private String orderId;
    private String customerCode;
    private String setMenuCode;
    private String evenDate;
    private int tableNumber;
    private double totalCost;

    public Order() {
    }

    public Order(String orderId, String customerCode, String setMenuCode, String evenDate, int tableNumber, double totalCost) {
        this.orderId = orderId;
        this.customerCode = customerCode;
        this.setMenuCode = setMenuCode;
        this.evenDate = evenDate;
        this.tableNumber = tableNumber;
        this.totalCost = totalCost;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSetMenuCode() {
        return setMenuCode;
    }

    public void setSetMenuCode(String setMenuCode) {
        this.setMenuCode = setMenuCode;
    }

    public String getEvenDate() {
        return evenDate;
    }

    public void setEvenDate(String evenDate) {
        this.evenDate = evenDate;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerCode=" + customerCode + ", setMenuCode=" + setMenuCode + ", evenDate=" + evenDate + ", tableNumber=" + tableNumber + ", totalCost=" + totalCost + '}';
    }
    
    
}
