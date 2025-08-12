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
    private String eventDate;
    private int tableNumber;
    private double totalCost;

    public Order() {
    }

    public Order(String orderId, String customerCode, String setMenuCode, String evenDate, int tableNumber, double totalCost) {
        this.orderId = orderId;
        this.customerCode = customerCode;
        this.setMenuCode = setMenuCode;
        this.eventDate = eventDate;
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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
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
        return "Order{" + "orderId=" + orderId + ", customerCode=" + customerCode + ", setMenuCode=" + setMenuCode + ", evenDate=" + eventDate + ", tableNumber=" + tableNumber + ", totalCost=" + totalCost + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Order order = (Order) obj;
        return orderId == order.orderId
                && tableNumber == order.tableNumber
                && Double.compare(order.totalCost, totalCost) == 0
                && Objects.equals(customerCode, order.customerCode)
                && Objects.equals(setMenuCode, order.setMenuCode)
                && Objects.equals(eventDate, order.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerCode, setMenuCode, tableNumber, eventDate, totalCost);
    }
    
}
