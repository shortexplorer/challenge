/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.model;

import java.util.List;

/**
 *
 * @author marisaeigen
 */
public class OrderLine {
    private int orderLineId;
    private int qTY;
    private List<Integer> ordersOfOrderLine;
    private List<Integer> productsOfOrderLine;

    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getqTY() {
        return qTY;
    }

    public void setqTY(int qTY) {
        this.qTY = qTY;
    }

    public List<Integer> getOrdersOfOrderLine() {
        return ordersOfOrderLine;
    }

    public void setOrdersOfOrderLine(List<Integer> ordersOfOrderLine) {
        this.ordersOfOrderLine = ordersOfOrderLine;
    }

    public List<Integer> getProductsOfOrderLine() {
        return productsOfOrderLine;
    }

    public void setProductsOfOrderLine(List<Integer> productsOfOrderLine) {
        this.productsOfOrderLine = productsOfOrderLine;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.orderLineId;
        hash = 97 * hash + this.qTY;
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
        final OrderLine other = (OrderLine) obj;
        if (this.orderLineId != other.orderLineId) {
            return false;
        }
        if (this.qTY != other.qTY) {
            return false;
        }
        return true;
    }
    
    
}
