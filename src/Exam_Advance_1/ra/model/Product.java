package Exam_Advance_1.ra.model;

import Exam_Advance_1.ra.service.CatalogService;
import Exam_Advance_1.ra.utility.InputMethod;

import java.util.List;

public class Product {
    private String productId;
    private String productName;
    private double productPrice;
    private String description;
    private int stock;
    private Catalog catalog;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, double productPrice, String description, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void displayData() {
        System.out.println("-----------------------------------------------------------------------" +
                "------------------------");
        System.out.printf("%-5s |%-15s |%-10s |%-15s |%-5s |%-20s |%-6s |\n"
                ,productId,productName,productPrice,description,stock,catalog.getCatalogName(),status);
    }

    ;

    public void inputData(boolean isAdd, List<Product> list) {
        if (isAdd) {
            productId = validateProductId(list);
            status = true;

        }
        System.out.println("Enter the name of the product: ");
        productName = InputMethod.getString();
        productPrice = validateProductPrice();
        System.out.println("Enter the description of the product: ");
        description = InputMethod.getString();
        stock = validateProductStock();
        catalog = validateProductCatalog();

    }
//    VALIDATE

    public String validateProductId(List<Product> list) {
        String regexId = "^P.{3}$";
        while (true) {
            System.out.println("Enter the product ID: ");
            String productIdInput = InputMethod.getString();

            if (productIdInput.matches(regexId)) {
                boolean checkExist = list.stream().anyMatch(p -> p.getProductId().equals(productIdInput));
                if (checkExist) {
                    System.err.println("The product ID already exists!");
                } else {
                    return productIdInput;
                }
            }else {
                System.err.println("The product ID must has total 4 char and begin with 'P' ");
            }
        }
    }

    public double validateProductPrice() {
        while (true) {
            System.out.println("Enter the price of product: ");
            double productPriceInput = InputMethod.getDouble();
            if (productPriceInput <= 0) {
                System.err.println("The price of product must > 0 !");
            } else {
                return productPriceInput;
            }
        }
    }

    public int validateProductStock() {
        while (true) {
            System.out.println("Enter the stock of product: ");
            int productStockInput = InputMethod.getInteger();
            if (productStockInput < 10) {
                System.err.println("The price of product must >= 10 !");
            } else {
                return productStockInput;
            }
        }
    }

    public Catalog validateProductCatalog() {
        CatalogService catalogService = new CatalogService();
        while (true) {
            System.out.println("Enter the id of category for this product: ");
            CatalogService.catalogs.forEach(Catalog::displayData);
            System.out.println("Your choice: ");
            int categoryIdChoice = InputMethod.getInteger();
            Catalog category = catalogService.findById(categoryIdChoice);
            if (category != null) {
                return category;
            } else {
                System.err.println("The id of category invalid, please try again!");
            }
        }
    }


}


