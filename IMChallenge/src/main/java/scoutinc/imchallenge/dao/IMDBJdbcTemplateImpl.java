/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import scoutinc.imchallenge.mapper.BinMapper;
import scoutinc.imchallenge.mapper.InventoryMapper;
import scoutinc.imchallenge.mapper.OrderLineMapper;
import scoutinc.imchallenge.mapper.OrderMapper;
import scoutinc.imchallenge.mapper.ProductMapper;
import scoutinc.imchallenge.model.Bin;
import scoutinc.imchallenge.model.Inventory;
import scoutinc.imchallenge.model.Order;
import scoutinc.imchallenge.model.Product;

/**
 *
 * @author marisaeigen
 */
public class IMDBJdbcTemplateImpl implements IMDao {
    
    private JdbcTemplate jdbcTemplate;
    private ProductMapper productMapper = new ProductMapper();
    private BinMapper binMapper = new BinMapper();
    private InventoryMapper inventoryMapper = new InventoryMapper();
    private OrderMapper orderMapper = new OrderMapper();
    private OrderLineMapper orderLineMapper = new OrderLineMapper();
    
    @Autowired
    public void jdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    
    public void setBinMapper(BinMapper binMapper) {
        this.binMapper = binMapper;
    }
    
    public void setInventoryMapper(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }
    
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }
    
    public void setOrderLineMapper(OrderLineMapper orderLineMapper) {
        this.orderLineMapper = orderLineMapper;
    }
    
    private static final String INSERT_PRODUCT
            = "insert into Product (SKU, ProductDescription) "
            + "values (?, ?)";
    
    private static final String DELETE_PRODUCT
            = "delete from Product "
            + "where ProductID = ?";
    
    private static final String UPDATE_PRODUCT
            = "update Product set SKU = ?, ProductDescription = ? "
            + " where ProductID = ?";
    
    private static final String SELECT_PRODUCT_BY_PRODUCT_ID
            = "select SKU, ProductDescription "
            + "from Product "
            + "where ProductID = ?";
    
    private static final String SELECT_ALL_PRODUCTS
            = "select * from Product";
    
    private static final String INSERT_BIN
            = "insert into Bin (BinName) "
            + "value (?)";
    
    private static final String DELETE_BIN
            = "delete from Bin "
            + "where BinID = ?";
    
    private static final String UPDATE_BIN
            = "update Bin set BinName = ? "
            + " where BinID = ?";
    
    private static final String SELECT_BIN_BY_BIN_ID
            = "select BinName "
            + "from Bin "
            + "where BinID = ?";
    
    private static final String SELECT_ALL_BINS
            = "select * from Bin";
    
    private static final String INSERT_INVENTORY
            = "insert into Inventory (ProductID, BinID, QTY) "
            + "values (?, ?, ?)";
    
    private static final String DELETE_INVENTORY
            = "delete from Inventory "
            + "where InventoryID = ?";
    
    private static final String UPDATE_INVENTORY
            = "update Inventory set ProductID = ?, BinID = ?, QTY = ? "
            + " where InventoryID = ?";
    
    private static final String SELECT_INVENTORY_BY_INVENTORY_ID
            = "select ProductID, BinID, QTY "
            + "from Inventory "
            + "where InventoryID = ?";
    
    private static final String SELECT_ALL_INVENTORY
            = "select * from Inventory";
    
    private static final String INSERT_ORDER
            = "insert into Order (OrderNumber, DateOrdered, CustomerName, CustomerAddress) "
            + "values (?, ?, ?, ?)";
    
    private static final String DELETE_ORDER
            = "delete from Order "
            + "where OrderID = ?";
    
    private static final String UPDATE_ORDER
            = "update Order set DateOrdered = ?, CustomerName = ?, CustomerAddress = ? "
            + " where OrderNumber = ?";
    
    private static final String SELECT_ORDER_BY_ORDER_ID
            = "select DateOrdered, CustomerName, CustomerAddress "
            + "from Order "
            + "where OrderNumber = ?";
    
    private static final String SELECT_ALL_ORDERS
            = "select * from Order";
    
    private static final String DELETE_ORDERLINES_BY_PRODUCT_ID
            = "delete from OrderLine "
            + "where ProductID = ?";
    
    private static final String DELETE_INVENTORY_BY_PRODUCT_ID
            = "delete from Inventory "
            + "where ProductID = ?";
    
    private static final String DELETE_INVENTORY_BY_BIN_ID
            = "delete from Inventory "
            + "where BinID = ?";
    
    private static final String DELETE_ORDERLINE_BY_INVENTORY_ID
            = "delete from OrderLine "
            + "where InventoryID = ?";
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addProduct(Product product) {
        jdbcTemplate.update(INSERT_PRODUCT,
                product.getsKU(),
                product.getProductDescription());
        
        // query inventory_management for newly created row's ProductID value
        int newProductId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        
        // set new ProductId value on the Product object
        product.setProductId(newProductId);
    }

    @Override
    public void deleteProduct(int productId) {
        // delete row(s) in OrderLine table with this ProductID
        jdbcTemplate.update(DELETE_ORDERLINES_BY_PRODUCT_ID, productId);
        
        // delete row(s) in Inventory table with this ProductID
        jdbcTemplate.update(DELETE_INVENTORY_BY_PRODUCT_ID, productId);
        
        // delete product from Product table
        jdbcTemplate.update(DELETE_PRODUCT, productId);
    }

    @Override
    public void editProduct(Product product) {
        jdbcTemplate.update(UPDATE_PRODUCT,
                product.getsKU(),
                product.getProductDescription(),
                product.getProductId());
    }

    @Override
    public Product viewProductById(int productId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_PRODUCT_ID, productMapper, productId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Product> viewAllProducts() {
        return jdbcTemplate.query(SELECT_ALL_PRODUCTS, productMapper);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addBin(Bin bin) {
        jdbcTemplate.update(INSERT_BIN,
                bin.getBinName());
        
        int newBinId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        bin.setBinId(newBinId);
    }

    @Override
    public void deleteBin(int binId) {
        // delete rows in Inventory table with this BinID
        jdbcTemplate.update(DELETE_INVENTORY_BY_BIN_ID, binId);
        
        // delete bin from Bin table
        jdbcTemplate.update(DELETE_BIN, binId);
    }

    @Override
    public void editBin(Bin bin) {
        jdbcTemplate.update(UPDATE_BIN,
                bin.getBinName(),
                bin.getBinId());
    }

    @Override
    public Bin viewBinById(int binId) {
        try {
            Bin bin = jdbcTemplate.queryForObject(SELECT_BIN_BY_BIN_ID, binMapper, binId);
            
            return bin;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Bin> viewAllBins() {
        return jdbcTemplate.query(SELECT_ALL_BINS, binMapper);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addInventory(Inventory inventory) {
        jdbcTemplate.update(INSERT_INVENTORY,
                inventory.getqTY(),
                inventory.getInventoryId());
        int newInventoryId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        inventory.setInventoryId(newInventoryId);
        
        List<Integer> productsInInventory = inventory.getProductsInInventory();
//       for (int currentProd : productsInInventory) {
//           insertRowIntoOrderLine();
//       }
    }

    @Override
    public void deleteInventory(int inventoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editInventory(Inventory inventory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        
//        jdbcTemplate.update(DELETE_ORDERLINE_BY_INVENTORY_ID, inventory.getInventoryId());
//        
//        List<Integer> productsOfInventory = inventory.getProductsInInventory();
    }

    @Override
    public Inventory viewInventoryById(int inventoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inventory> viewAllInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteOrder(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order viewOrderByID(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> viewAllOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
