DROP DATABASE IF EXISTS inventory_management_test;

CREATE DATABASE inventory_management_test;

USE inventory_management_test;

CREATE TABLE Product
(ProductID int NOT NULL auto_increment,
SKU char(10) NOT NULL UNIQUE,
ProductDescription varchar(30) NOT NULL,
PRIMARY KEY (ProductId)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;

CREATE TABLE `Order`
(OrderID int NOT NULL auto_increment,
DateOrdered datetime NOT NULL,
CustomerName varchar(50) NOT NULL,
CustomerAddress varchar(100) NOT NULL,
PRIMARY KEY (OrderID)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;

CREATE TABLE OrderLine
(OrderLineID int NOT NULL auto_increment,
OrderID int NOT NULL,
ProductID int NOT NULL,
PRIMARY KEY (OrderLineID),
FOREIGN KEY (OrderID) REFERENCES `Order` (OrderID),
FOREIGN KEY (ProductID) REFERENCES Product (ProductID)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;

CREATE TABLE Bin
(BinID int NOT NULL auto_increment,
BinName varchar(30) NOT NULL UNIQUE,
PRIMARY KEY (BinID)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;

CREATE TABLE Inventory
(InventoryID int NOT NULL auto_increment,
ProductID int NOT NULL,
BinID int NOT NULL,
QTY int NOT NULL,
PRIMARY KEY (InventoryID),
FOREIGN KEY (ProductID) REFERENCES Product (ProductID),
FOREIGN KEY (BinID) REFERENCES Bin (BinID)
) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;