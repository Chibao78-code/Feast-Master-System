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

    private int orderId;
    private String customerCode;
    private String setMenuCode;
    private int tableNumber;
    private String eventDate;
    private double totalCost;

    public Order() {
    }

    public Order(int orderId, String customerCode, String setMenuCode, int tableNumber, String eventDate, double totalCost) {
        this.orderId = orderId;
        this.customerCode = customerCode;
        this.setMenuCode = setMenuCode;
        this.tableNumber = tableNumber;
        this.eventDate = eventDate;
        this.totalCost = totalCost;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return String.format("Order ID: %d\nCustomer Code: %s\nSet Menu Code: %s\nTables: %d\nEvent Date: %s\nTotal Cost: %.2f VND",
                orderId, customerCode, setMenuCode, tableNumber, eventDate, totalCost);
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
