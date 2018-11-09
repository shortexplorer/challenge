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
public class InventoryVM {
    Inventory inventoryBasis;
    List<Product> productObjectsOfInv;
    List<Bin> binObjectsOfInv;

    public Inventory getInventoryBasis() {
        return inventoryBasis;
    }

    public void setInventoryBasis(Inventory inventoryBasis) {
        this.inventoryBasis = inventoryBasis;
    }

    public List<Product> getProductObjectsOfInv() {
        return productObjectsOfInv;
    }

    public void setProductObjectsOfInv(List<Product> productObjectsOfInv) {
        this.productObjectsOfInv = productObjectsOfInv;
    }

    public List<Bin> getBinObjectsOfInv() {
        return binObjectsOfInv;
    }

    public void setBinObjectsOfInv(List<Bin> binObjectsOfInv) {
        this.binObjectsOfInv = binObjectsOfInv;
    }
    
}
