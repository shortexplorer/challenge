/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import scoutinc.imchallenge.model.Bin;

/**
 *
 * @author marisaeigen
 */
public class BinMapper implements RowMapper<Bin> {
    
    @Override
    public Bin mapRow(ResultSet rs, int i) throws SQLException {
        Bin bin = new Bin();
        bin.setBinName(rs.getString("BinName"));
        bin.setBinId(rs.getInt("BinID"));
        
        return bin;
    }
    
}
