package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.searchEngine.Searchable;
import org.skypro.skyshop.searchEngine.exception.BestResultNotFoundException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        System.out.println("HW: 2");

        ProductBasket basket = new ProductBasket();
        // step 1
        basket.addProduct(new SimpleProduct("Spoon", 12));
        basket.addProduct(new SimpleProduct("Screwdriver", 100));
        basket.addProduct(new SimpleProduct("Cup", 5));
        basket.addProduct(new SimpleProduct("Lamp", 10));
        basket.addProduct(new SimpleProduct("Oil", 30));
        // step 2
        basket.addProduct(new SimpleProduct("Vodka", 6)); // This item will add successful now.
        // step 3
        basket.printBasket();
        // step 4
        System.out.println(basket.getTotalPrice());
        // step 5
        System.out.println(basket.hasProduct("Screwdriver"));
        // step 6
        System.out.println(basket.hasProduct("Vodka"));
        // step 7
        basket.clear();
        // step 8
        basket.printBasket();
        // step 9
        basket.getTotalPrice();
        // step 10
        System.out.println(basket.hasProduct("Matryoshka"));

        System.out.println();
        System.out.println("HW: 3");

        basket.clear();
        basket.addProduct(new SimpleProduct("SimpleProduct-1", 2));
        basket.addProduct(new FixPriceProduct("SpecialProduct-1"));
        basket.addProduct(new DiscountedProduct("SpecialProduct-2", 100, 10));

        basket.printBasket();

        System.out.println();
        System.out.println("HW: 4");

        SearchEngine engine = new SearchEngine();

        engine.add(new SimpleProduct("Simple Product (Tree)", 2))
                .add(new FixPriceProduct("Special Product 1"))
                .add(new DiscountedProduct("Special Product 2", 100, 10))
                .add(new SimpleProduct("Special product for products", 150))
                .add(new Article("Article about Tree", "So many symbols about trees."))
                .add(new Article("Article about Sea", "So many symbols about sea."));

        String[] needles = {"Tree", "Sea", "Special", "Product", "many symbols"};

        for (String needle : needles) {
            System.out.println();
            System.out.println("Searching \"" + needle + "\":");
            Set<Searchable> result = engine.search(needle);

            for (Searchable item : result) {

                if (item == null) {
                    continue;
                }

                System.out.println("Type: " + item.getContentType() + " " + "Name: " + item.getName());
            }
        }

        System.out.println();
        System.out.println("HW: 5");

        try {
            new SimpleProduct("    ", 2);   // wrong name case 1
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            new SimpleProduct(null, 2);     // wrong name case 2
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            new SimpleProduct("Wrong Product", 0);  // wrong price
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            new DiscountedProduct("Wrong Product", 45, 105);    // wrong discount
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            Searchable bestProduct;
            bestProduct = engine.searchBestResult("product"); // case 1: object isset
            System.out.println("Best Product found: Type: " + bestProduct.getContentType() + " " + "Name: " + bestProduct.getName());
        } catch (BestResultNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            engine.searchBestResult("soul"); // case 2: object NOT isset
        } catch (BestResultNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println();
        System.out.println("HW: 6");

        // step 1
        List<Product> productsDeleted;
        System.out.println();
        System.out.println("Basket before product deleting:");
        basket.printBasket();
        productsDeleted = basket.deleteProductsByName("SpecialProduct-1");
        System.out.println();
        System.out.println("Basket after product deleting:");
        basket.printBasket();

        // step 2
        Iterator<Product> iteratorOfDeletedProducts = productsDeleted.iterator();
        System.out.println();
        System.out.println("Products deleted:");

        while (iteratorOfDeletedProducts.hasNext()) {
            Product productDeleted = iteratorOfDeletedProducts.next();
            System.out.println(productDeleted);
        }

        // step 3
        System.out.println();
        System.out.println("Basket printing using printBasket():");
        basket.printBasket();

        // step 4
        List<Product> emptyProductsDeleted;
        emptyProductsDeleted = basket.deleteProductsByName("some-name");

        // step 5
        if (emptyProductsDeleted.isEmpty()) {
            System.out.println();
            System.out.println("Список пуст");
        }

        // step 6
        basket.printBasket();

        System.out.println();
        System.out.println("HW: 8");

        SearchEngine engineHomeWork8 = new SearchEngine();

        engineHomeWork8.add(new SimpleProduct("Product A", 2))
                .add(new FixPriceProduct("Special Product BBB"))
                .add(new DiscountedProduct("Special Product AA", 100, 10))
                .add(new SimpleProduct("Best Product", 150))
                .add(new Article("Article about Product Tree", "So many symbols about trees."))
                .add(new Article("Best Product", "So many symbols about the Bes Product."))
                .add(new Article("Article with same length title about a Product Banana", "some content"))
                .add(new Article("Article with same length title about a Product Apple_", "some content"));

        Set<Searchable> result = engineHomeWork8.search("Product");
        System.out.println("Найдено по ключевому слову \"Product\" с кастомной сортировкой результата:");

        for (Searchable item : result) {
            System.out.println(item.getName());
        }
    }
}
