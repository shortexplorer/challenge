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
public class OrderLineVM {
    OrderLine orderBasis;
    List<Order> orderObjectsOfOL;
    List<Product> productObjectsofOL;

    public OrderLine getOrderBasis() {
        return orderBasis;
    }

    public void setOrderBasis(OrderLine orderBasis) {
        this.orderBasis = orderBasis;
    }

    public List<Order> getOrderObjectsOfOL() {
        return orderObjectsOfOL;
    }

    public void setOrderObjectsOfOL(List<Order> orderObjectsOfOL) {
        this.orderObjectsOfOL = orderObjectsOfOL;
    }

    public List<Product> getProductObjectsofOL() {
        return productObjectsofOL;
    }

    public void setProductObjectsofOL(List<Product> productObjectsofOL) {
        this.productObjectsofOL = productObjectsofOL;
    }
    
}
