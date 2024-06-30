package Exam_Advance_1.ra.service;

import Exam_Advance_1.ra.model.Catalog;
import Exam_Advance_1.ra.utility.InputMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CatalogService implements IGenericService<Catalog, Integer> {
    public static final List<Catalog> catalogs = new ArrayList<>();

    @Override
    public Catalog findById(Integer id) {
        return catalogs.stream().filter(c -> c.getCatalogId() == id).findFirst().orElse(null);
    }

    @Override
    public void addNew() {
        System.out.println("Enter the number of category you want to add");
        byte number = InputMethod.getByte();

        for (int i = 1; i <= number; i++) {
            System.out.println("Enter the information of category " + i);
            Catalog newCatalog = new Catalog();
            newCatalog.inputData(true);
            catalogs.add(newCatalog);
        }

        System.out.println("Add successful!!");
    }

    @Override
    public void showAll() {
        if (!catalogs.isEmpty()) {
            System.out.printf("%-5s |%-20s |%-20s |\n"
                    , "ID", "NAME", "DESCRIPTION");
            catalogs.forEach(Catalog::displayData);
        } else {
            System.err.println("No catalog found!");
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter the id of the catalog you want to edit");
        int id = InputMethod.getInteger();
        Catalog categoryEdit = findById(id);
        if (categoryEdit != null) {
            System.out.println("The previous information of this category");
            categoryEdit.displayData();
            categoryEdit.inputData(false);
            System.out.println("Edit successful!!");
        } else {
            System.err.println("The catalog you want to edit does not exist");
        }


    }

    @Override
    public void delete() {
        System.out.println("Enter the id of the catalog you want to delete");
        int id = InputMethod.getInteger();
        Catalog categoryDel = findById(id);
        if (categoryDel != null) {
//            check if cate have product cannot delete:
            if (ProductService.products.stream().anyMatch(p -> p.getCatalog().equals(categoryDel))) {
                System.err.println("Can not delete this category because it already has product");
            } else {
                catalogs.remove(categoryDel);
                System.out.println("Delete successful!!");
            }

        } else {
            System.err.println("The catalog you want to edit does not exist");
        }
    }

    public static int getNewId() {
        int max = catalogs.stream().map(Catalog::getCatalogId).max(Comparator.naturalOrder()).orElse(0);
        return max + 1;
    }
}
