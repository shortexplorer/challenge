/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutinc.imchallenge.dao;

import java.util.List;
import scoutinc.imchallenge.model.Bin;
import scoutinc.imchallenge.model.Inventory;
import scoutinc.imchallenge.model.Order;
import scoutinc.imchallenge.model.Product;

/**
 *
 * @author marisaeigen
 */
public interface IMDao {
    
    public void addProduct(Product product);
    
    public void deleteProduct(int productId);
    
    public void editProduct(Product product);
    
    public Product viewProductById(int productId);
    
    public List<Product> viewAllProducts();
    
    public void addBin(Bin bin);
    
    public void deleteBin(int binId);
    
    public void editBin(Bin bin);
    
    public Bin viewBinById(int binId);
    
    public List<Bin> viewAllBins();
    
    public void addInventory(Inventory inventory);
    
    public void deleteInventory(int inventoryId);
    
    public void editInventory(Inventory inventory);
    
    public Inventory viewInventoryById(int inventoryId);
    
    public List<Inventory> viewAllInventory();
    
    public void addOrder(Order order);
    
    public void deleteOrder(int orderId);
    
    public void editOrder(Order order);
    
    public Order viewOrderByID(int orderId);
    
    public List<Order> viewAllOrders();
}
