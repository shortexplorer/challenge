/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import scoutinc.imchallenge.model.OrderLine;

/**
 *
 * @author marisaeigen
 */
public class OrderLineMapper implements RowMapper<OrderLine> {

    @Override
    public OrderLine mapRow(ResultSet rs, int i) throws SQLException {
        
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderLineId(rs.getInt("OrderLineID"));
        
        return orderLine;
    }
    
}
