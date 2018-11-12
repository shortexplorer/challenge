/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author marisaeigen
 */
public class Order {
    
    private int orderNumber;
    private LocalDate dateOrdered;
    private String customerName;
    private String customerAddress;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.orderNumber;
        hash = 41 * hash + Objects.hashCode(this.dateOrdered);
        hash = 41 * hash + Objects.hashCode(this.customerName);
        hash = 41 * hash + Objects.hashCode(this.customerAddress);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.customerAddress, other.customerAddress)) {
            return false;
        }
        if (!Objects.equals(this.dateOrdered, other.dateOrdered)) {
            return false;
        }
        return true;
    }
    
    
}
