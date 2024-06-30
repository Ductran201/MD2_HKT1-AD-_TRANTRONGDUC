package Exam_Advance_1.ra.service;

import Exam_Advance_1.ra.model.Cart;
import Exam_Advance_1.ra.utility.InputMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CartService implements IGenericService<Cart,Integer>{
    public static List<Cart> carts=new ArrayList<>();

    @Override
    public Cart findById(Integer id) {
//        return carts.stream().filter(c->c.getCartItemId()==id).findFirst().get();
        return carts.stream().filter(c -> c.getCartItemId() == id).findFirst().orElse(null);
    }

    @Override
    public void showAll() {
        if (!carts.isEmpty()) {
            System.out.printf("%-5s |%-20s |%-20s |%5s \n", "ID", "Product Name", "Price", "Quantity");
            carts.forEach(Cart::displayData);
        } else {
            System.err.println("No have any items");
        }
    }

    @Override
    public void addNew() {
        Cart newCart = new Cart();
        newCart.inputData(true, carts);
        carts.add(newCart);
    }

    @Override
    public void edit() {
        System.out.println("Enter the id of cart item to edit");
        int id = InputMethod.getInteger();
        Cart cartItemEdit = findById(id);
        if (cartItemEdit != null) {
            System.out.println("The previous information of this cart item: ");
            cartItemEdit.displayData();
            cartItemEdit.inputData(false, carts);
        } else {
            System.err.println("No found cart with id " + id);
        }

    }

    @Override
    public void delete() {
        System.out.println("Enter the id of cart item to delete");
        int id = InputMethod.getInteger();
        Cart cartItemDelete = findById(id);
        if (cartItemDelete != null) {
            carts.remove(cartItemDelete);
            System.out.println("Delete successful");
        } else {
            System.err.println("No found cart with id " + id);
        }
    }

    public void deleteAllCart() {
        System.err.println("Do you continue to delete all cart items(True:Yes/false:No)");
        if (InputMethod.getBoolean()) {
            carts.clear();
            System.out.println("Delete all items of cart successfully");
        }
    }

    public static int getNewId() {
        return carts.stream()
                .map(Cart::getCartItemId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
