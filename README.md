**Inventory Management Application**



An online seller fulfills customer orders placed on the seller&#39;s website and maintains stock of multiple products in their warehouse. The online seller uses inventory management software to accomplish these needs.

The warehouse is divided into multiple bins (shelves or areas of the warehouse) to hold inventory. A bin can contain multiple different products, and a product can have inventory in multiple different bins.

Your task is to design an application, either a REST API or a Web Application, using your language and framework of choice, that will allow warehouse staff to view, create, edit, and delete: Products, Bins, Inventory Levels, and Orders. Data should be stored in a SQL database of your choice.

While we encourage using C# and Microsoft SQL Server, please use whatever language and SQL database you are most comfortable with.





**Product**
A Product record is the basic information about the Product that a seller carries.
| **Field Name** | **Data Type** |
| --- | --- |
| ProductID | PK |
| SKU | String (unique) |
| ProductDescription | String |



**Order**
Orders are placed by a customer for one or more products
| **Field Name** | **Data Type** |
| --- | --- |
| OrderNumber | String (unique) |
| DateOrdered | DateTime |
| CustomerName | string |
| CustomerAddress | string |

**Order Lines**
Order lines are related to an Order, and specify what Product has been ordered, and how many
| **Field Name** | **Data Type** |
| --- | --- |
| OrderLineID | PK |
| OrderID | FK |
| ProductID | FK |
| QTY | Integer |



**Bins**
Bins are the individual shelves, pallets, or other areas in the warehouse where inventory is located
| **Field Name** | **Data Type** |
| --- | --- |
| BinID | PK |
| BinName | String (unique) |



**Inventory**

Inventory records point to the Product in inventory, and the Bin that it is stored in.
There should not be multiple rows for the same Product and Bin.
Zero QTYs do not need to be stored.

| **Field Name** | **Data Type** |
| --- | --- |
| InventoryID | PK |
| ProductID | FK |
| BinID | FK |
| QTY | Integer |
