package Exam_Advance_1.ra.service;

import Exam_Advance_1.ra.model.Product;
import Exam_Advance_1.ra.utility.InputMethod;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product, String>{
    public static final List<Product> products=new ArrayList<>();

    @Override
    public Product findById(String id) {

        return products.stream().filter(p-> p.getProductId().equals(id)).findFirst().orElse(null);

    }

    @Override
    public void addNew() {
        System.out.println("Enter the number of products you want to add");
        byte number = InputMethod.getByte();

        for (int i = 1; i <=number ; i++) {
            System.out.println("Enter the information of product "+ i);
            Product newProduct = new Product();
            newProduct.inputData(true,products);
            products.add(newProduct);
        }

        System.out.println("Add successfully!!");
    }

    @Override
    public void showAll() {
        if (!products.isEmpty()) {
            System.out.printf("%-5s |%-15s |%-10s |%-15s |%-5s |%-20s |%-6s |\n"
                    ,"ID","Name","Price","description","stock","catalog Name","status");
            products.forEach(Product::displayData);
        }else {
            System.err.println("There is no product in the list");
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter id of the product you want to edit");
        String id = InputMethod.getString();
        Product productEdit=findById(id);
        if (productEdit!=null){
            System.out.println("The previous information of this product: ");
            productEdit.displayData();
            productEdit.inputData(false,products);
        }else {
            System.err.println("The product does not exist");
        }
    }

    @Override
    public void delete() {
        System.out.println("Enter id of the product you want to delete");
        String id = InputMethod.getString();
        Product productDel=findById(id);
        if (productDel!=null){
            products.remove(productDel);
            System.out.println("Delete successfully");
        }else {
            System.err.println("The product does not exist");
        }
    }

    public void sortByPrice(){
        System.out.println("List Product sorted by price descending");
        products.stream()
                .sorted((o1, o2) -> (int) (o2.getProductPrice()- o1.getProductPrice()))
                .forEach(Product::displayData);
    }

    public void searchByName(){
        System.out.println("Enter the name of the product you want to search");
        String searchNameInput=InputMethod.getString();
        products.stream()
                .filter(p->p.getProductName().toLowerCase().contains(searchNameInput.toLowerCase()))
                .forEach(Product::displayData);
    }

}
