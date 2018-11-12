/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import scoutinc.imchallenge.model.Inventory;

/**
 *
 * @author marisaeigen
 */
public class InventoryMapper implements RowMapper<Inventory> {

    @Override
    public Inventory mapRow(ResultSet rs, int i) throws SQLException {
        
        Inventory inventory = new Inventory();
        inventory.setqTY(rs.getInt("QTY"));
        inventory.setInventoryId(rs.getInt("InventoryID"));
        
        return inventory;
    }
    
}
