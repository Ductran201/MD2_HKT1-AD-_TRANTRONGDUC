package Exam_Advance_1.ra.model;

import Exam_Advance_1.ra.service.CartService;
import Exam_Advance_1.ra.service.ProductService;
import Exam_Advance_1.ra.utility.InputMethod;

import java.util.List;

public class Cart {
    private int cartItemId;
    private String productName;
    private double price;
    private int quantity;

    public Cart() {
    }

    public Cart(int cartItemId, String productName, int price, int quantity) {
        this.cartItemId = cartItemId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayData() {
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-5d |%-20s |%-20f |%5d \n", cartItemId, productName, price, quantity);
    }

    public void inputData(boolean isAdd, List<Cart> cartList) {
        ProductService productService = new ProductService();

        if (isAdd) {
            cartItemId = CartService.getNewId();
        }

        while (true) {
            System.out.println("Choose the id of the product you want add to cart");

            productService.showAll();

            String id = InputMethod.getString();

            if (productService.findById(id) == null) {
                System.err.println("No found the product with id " + id);

            } else if (cartList.stream()
                    .anyMatch(c -> c.getProductName()
                            .equals(productService.findById(id).getProductName()))) {
                //can not add more because duplicate
                System.err.println("This product has already been added");
            } else {
                productName = productService.findById(id).getProductName();
                price = productService.findById(id).getProductPrice();
                break;
            }
        }

        if (isAdd) {
            quantity = 1;
            System.out.println("Add "+ productName+" successfully to the cart" );
        } else {
            System.out.println("Enter the total quantity of this product you want to order: ");
            quantity = InputMethod.getInteger();
            System.out.println("Edit successfully!!");
        }


    }
}
