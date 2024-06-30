package Exam_Advance_1.ra.model;

import Exam_Advance_1.ra.service.CatalogService;
import Exam_Advance_1.ra.utility.InputMethod;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private String descriptions;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, String descriptions) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void displayData(){
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-5d |%-20s |%-20s |\n"
                , catalogId, catalogName, descriptions);
    }


    public void inputData(boolean isAdd){
        if(isAdd){
            this.catalogId= CatalogService.getNewId();
        }
        System.out.println("Enter the catalog name: ");
        this.catalogName = InputMethod.getString();
        System.out.println("Enter the descriptions: ");
        this.descriptions = InputMethod.getString();
    }

}
