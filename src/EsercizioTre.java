import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class EsercizioTre {
    public static void main(String[] args) {
        //-------------------------------------MAGAZZINO-------------------
        List<Product> warehouse = new ArrayList<>();
        warehouse.add(new Product("Lord od Rings", "Books", 150));
        warehouse.add(new Product("Ten Little Indians", "Books", 30));
        warehouse.add(new Product("Word of Warcraft", "Games", 30));
        warehouse.add(new Product("White T-Shirt", "Clothes", 20));
        warehouse.add(new Product("Old Jeans", "Clothes", 15));
        warehouse.add(new Product("One Plus", "Tech", 400));
        warehouse.add(new Product("Auto Vacuum Cleaner", "Tech", 350));
        warehouse.add(new Product("Star Wars Lego", "Baby", 100));
        warehouse.add(new Product("stroller", "Baby", 99));

        //Ottengo una list della categoria Tech
        List<Product> TechCategoryList = warehouse.stream().filter(product->product.getCategory().equals("Tech")).toList();
        //Applico lo sconto del 10%
        TechCategoryList.stream().forEach(product -> product.setPrice(product.getPrice()*10/100));
        TechCategoryList.forEach(System.out::println);
    }
}
