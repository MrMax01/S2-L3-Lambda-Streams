import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EsercizioUno {
    public static void main(String[] args) {
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
        //PREDICATE
        Predicate<Product> isABook = p-> p.getCategory().equals("Books");
        Predicate <Product> moreThan100 = p -> p.getPrice() >100;
        System.out.println("---------------BOOKS, PRICE>100----------------");
        List<Product> searchResult = warehouse.stream().filter(isABook.and(moreThan100)).toList();
        searchResult.forEach(System.out::println);

    }


}
