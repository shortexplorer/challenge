/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.model;

import java.util.Objects;

/**
 *
 * @author marisaeigen
 */
public class Product {
    
    private int productId;
    private String sKU;
    private String productDescription;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getsKU() {
        return sKU;
    }

    public void setsKU(String sKU) {
        this.sKU = sKU;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.productId;
        hash = 37 * hash + Objects.hashCode(this.sKU);
        hash = 37 * hash + Objects.hashCode(this.productDescription);
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
        final Product other = (Product) obj;
        if (this.productId != other.productId) {
            return false;
        }
        if (!Objects.equals(this.sKU, other.sKU)) {
            return false;
        }
        if (!Objects.equals(this.productDescription, other.productDescription)) {
            return false;
        }
        return true;
    }
    
    
}
