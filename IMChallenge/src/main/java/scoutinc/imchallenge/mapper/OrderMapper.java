/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import scoutinc.imchallenge.model.Order;

/**
 *
 * @author marisaeigen
 */
public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int i) throws SQLException {
        
        Order order = new Order();
        order.setDateOrdered(rs.getTimestamp("DateOrdered").toLocalDateTime().toLocalDate());
        order.setCustomerName(rs.getString("CustomerName"));
        order.setCustomerAddress(rs.getString("CustomerAddress"));
        order.setOrderNumber(rs.getInt("OrderNumber"));
        
        return order;
    }  
    
}
