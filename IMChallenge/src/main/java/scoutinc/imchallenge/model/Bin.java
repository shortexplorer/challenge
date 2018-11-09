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
public class Bin {
    
    private int binId;
    private String binName;

    public int getBinId() {
        return binId;
    }

    public void setBinId(int binId) {
        this.binId = binId;
    }

    public String getBinName() {
        return binName;
    }

    public void setBinName(String binName) {
        this.binName = binName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.binId;
        hash = 71 * hash + Objects.hashCode(this.binName);
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
        final Bin other = (Bin) obj;
        if (this.binId != other.binId) {
            return false;
        }
        if (!Objects.equals(this.binName, other.binName)) {
            return false;
        }
        return true;
    }
    
    
}
