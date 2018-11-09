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
public class Inventory {
    
    private int inventoryId;
    private int qTY;
    private List<Integer> productsInInventory;
    private List<Integer> binsOfInventory;

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getqTY() {
        return qTY;
    }

    public void setqTY(int qTY) {
        this.qTY = qTY;
    }

    public List<Integer> getProductsInInventory() {
        return productsInInventory;
    }

    public void setProductsInInventory(List<Integer> productsInInventory) {
        this.productsInInventory = productsInInventory;
    }

    public List<Integer> getBinsOfInventory() {
        return binsOfInventory;
    }

    public void setBinsOfInventory(List<Integer> binsOfInventory) {
        this.binsOfInventory = binsOfInventory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.inventoryId;
        hash = 59 * hash + this.qTY;
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
        final Inventory other = (Inventory) obj;
        if (this.inventoryId != other.inventoryId) {
            return false;
        }
        if (this.qTY != other.qTY) {
            return false;
        }
        return true;
    }
    
    
}
