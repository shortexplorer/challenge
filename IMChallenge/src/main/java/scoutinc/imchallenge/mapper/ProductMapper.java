/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import scoutinc.imchallenge.model.Product;

/**
 *
 * @author marisaeigen
 */
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        
        Product product = new Product();
        product.setsKU(rs.getString("SKU"));
        product.setProductDescription(rs.getString("ProductDescription"));
        product.setProductId(rs.getInt("ProductID"));
        
        return product;
    }
    
}
