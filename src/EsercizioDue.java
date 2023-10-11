import entities.Customer;
import entities.Order;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class EsercizioDue {
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



        //Creo i/un Customer
        Customer max = new Customer("Massimo", 2);

        //Creo qualche list di Prodotti
        List<Product> cart = randomListOfProducts(warehouse);
        List<Product> cart2 = randomListOfProducts(warehouse);
        List<Product> cart3 = randomListOfProducts(warehouse);
        List<Product> cart4 = randomListOfProducts(warehouse);
        List<Product> cart5 = randomListOfProducts(warehouse);

        //creo una lista di ordini
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(cart, max));
        orderList.add(new Order(cart2, max));
        orderList.add(new Order(cart3, max));
        orderList.add(new Order(cart4, max));
        orderList.add(new Order(cart5, max));

        System.out.println("----------Ordine con prodotti category baby-----------");
       Predicate<Order> findCategoryBaby = order -> order.getProducts().stream().anyMatch(product->product.getCategory().equals("Baby"));

        List<Order> searchResult = orderList.stream().filter(findCategoryBaby).toList();

        searchResult.forEach(System.out::println);

    }

    public static List<Product> randomListOfProducts(List<Product> catalog){

        Random rnd= new Random();
        List<Product> output= new ArrayList<>();
        for (int i = 0; i < rnd.nextInt(1, catalog.size()); i++) {
            output.add(catalog.get(rnd.nextInt(0, catalog.size()-1)));
        }

        return output;
    }
}
