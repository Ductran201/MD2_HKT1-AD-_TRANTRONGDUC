package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.model.Product;
import Exam_Advance_1.ra.service.CartService;
import Exam_Advance_1.ra.service.CatalogService;
import Exam_Advance_1.ra.service.ProductService;
import Exam_Advance_1.ra.utility.InputMethod;


public class BookManagement {
    static CatalogService categoryService = new CatalogService();
    static ProductService productService = new ProductService();
    static CartService cartService = new CartService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("**************************BASIC-MENU**************************\n" +
                    "1. Quản lý danh mục [5 điểm]\n" +
                    "2. Quản lý sản phẩm [5 điểm]\n" +
                    "3. Quản lý nguoi dung [5 điểm]\n" +
                    "4. Thoát [5 điểm]");
            System.out.println("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    openCatalogManagement();
                    break;
                case 2:
                    openProductManagement();
                    break;
                case 3:
                    openUserManagement();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void openCatalogManagement() {
        while (true) {
            System.out.println("********************CATALOG-MANAGEMENT********************\n" +
                    "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục [5 điểm]\n" +
                    "2. Hiển thị thông tin tất cả các danh mục [5 điểm]\n" +
                    "3. Sửa tên danh mục theo mã danh mục [5 điểm]\n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm) [5 điểm]\n" +
                    "5. Quay lại");
            System.out.println("Your choice: ");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    categoryService.addNew();
                    break;
                case 2:
                    categoryService.showAll();
                    break;
                case 3:
                    categoryService.edit();
                    break;
                case 4:
                    categoryService.delete();
                    break;
                case 5:
                    return;

            }

        }
    }

    public static void openProductManagement() {
        while (true) {
            System.out.println("********************PRODUCT-MANAGEMENT********************\n" +
                    "1. Nhập số sản sản phẩm và nhập thông tin sản phẩm [5 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [5 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo giá giảm dần [5 điểm]\n" +
                    "4. Xóa sản phẩm theo mã [5 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi thông tin của sách theo mã sách [10 điểm]\n" +
                    "7. Quay lại\n");

            System.out.println("Your choice: ");

            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    productService.addNew();
                    break;
                case 2:
                    productService.showAll();
                    break;
                case 3:
                    productService.sortByPrice();
                    break;
                case 4:
                    productService.delete();
                    break;
                case 5:
                    productService.searchByName();
                    break;
                case 6:
                    productService.edit();
                    break;
                case 7:
                    return;
            }

        }
    }

    public static void openUserManagement() {
        while (true) {
            System.out.println("**************************MENU-USER**************************\n" +
                    "1. Xem danh sách sản phẩm\n" +
                    "2. Thêm vào giỏ hàng\n" +
                    "3. Xem tất cả sản phẩm giỏ hàng\n" +
                    "4. Thay đổi số lượng sản phẩm trong giỏ hàng\n" +
                    "5. Xóa 1 sản phẩm trong giỏ hàng\n" +
                    "6. Xóa toàn bộ sản phẩm trong giỏ hàng\n" +
                    "7. Quay lại");

            System.out.println("Your choice: ");

            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    System.out.printf("%-5s |%-15s |%-10s |%-15s |%-5s |%-20s |%-6s |\n"
                            ,"ID","Name","Price","description","stock","catalog Name","status");
                    ProductService.products.forEach(Product::displayData);
                    break;
                case 2:
                    cartService.addNew();
                    break;
                case 3:
                    cartService.showAll();
                    break;
                case 4:
                    cartService.edit();
                    break;
                case 5:
                    cartService.delete();
                    break;
                case 6:
                    cartService.deleteAllCart();
                    break;
                case 7:
                    return;
            }

        }
    }
}
