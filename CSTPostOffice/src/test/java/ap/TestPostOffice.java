package ap;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

@Test
public class TestPostOffice {

    /*
    * TC1
    * p.name -> is unique
    * po.getNumberOfProducts()-> 2
    * po.maxNumberOfProducts -> 4
    * p.price -> 1
    * p.quantity -> 1
    * accepted
    * */
    @Test
    public void testValidPostOfficeWithAddNewProduct(){
        PostOffice po = new PostOffice(4, new ArrayList<Product>());

        //Adds Products
        for(int i = 1; i<=2; i++){
            Product p = new Product("prod"+i,"description"+i,1,1);
            p.store(1);
            assertTrue(po.addNewProduct(p));
        }

        //Assert
        assertEquals(po.getMaxNumberOfProducts(), 4);
        assertEquals(po.getNumberOfProducts(), 2);
        List<Product> products = po.getProducts();
        for(Product p : products){
            assertEquals(p.getCurrentQuantity(), 1);
            assertEquals(p.getPrice(), 1);
        }
    }

    /*
     * TC2
     * p.name -> not unique
     * po.getNumberOfProducts()-> 3
     * po.maxNumberOfProducts -> 5
     * p.price -> 2
     * p.quantity -> 2
     * rejected
     * */
    @Test
    public void testInvalidNameforProduct(){
        List<Product> productsList = new ArrayList<Product>();
        for(int i = 1; i<=3; i++){
            Product p = new Product("prod"+i,"description"+i,2,1);
            p.store(2);
            productsList.add(p);
        }
        PostOffice po = new PostOffice(5, productsList);

        //Tries to add product with non unique name
        Product p3 = new Product("prod1","description3",2,1);
        p3.store(2);
        assertFalse(po.addNewProduct(p3));

        //Assert
        List<Product> products = po.getProducts();
        for(Product p : products){
            assertEquals(p.getCurrentQuantity(), 2);
            assertEquals(p.getPrice(), 2);
        }
        assertEquals(po.getMaxNumberOfProducts(), 5);
        assertEquals(po.getNumberOfProducts(),3);
    }

    /*
     * TC3
     * p.name -> is unique
     * po.getNumberOfProducts()-> 11
     * po.maxNumberOfProducts -> 13
     * p.price -> 15
     * p.quantity -> 3
     * accepted
     * */
    @Test
    public void testValidPostOfficeWithRemoveProductandAddNewProduct(){
        PostOffice po = new PostOffice(13, new ArrayList<Product>());
        //Adds products
        for(int i = 1; i<=12; i++){
            Product p = new Product("prod"+i,"description"+i,15,2);
            p.store(3);
            assertTrue(po.addNewProduct(p));
        }

        //Removes product to get desired quantity
        assertTrue(po.removeProduct("prod12"));

        //Assert
        assertEquals(po.getMaxNumberOfProducts(), 13);
        List<Product> products = po.getProducts();
        for(Product p : products){
            assertEquals(p.getCurrentQuantity(), 3);
            assertEquals(p.getPrice(), 15);
        }
        assertEquals(po.getNumberOfProducts(), 11);
    }

    /*
     * TC4
     * p.name -> is unique
     * po.getNumberOfProducts()-> 12
     * po.maxNumberOfProducts -> 14
     * p.price -> 25
     * p.quantity -> 4
     * accepted
     * */
    @Test
    public void testValidPostOfficeWithSetMaxNumberOfProducts(){
        List<Product> productsList = new ArrayList<Product>();
        for(int i = 1; i<=12; i++){
            Product p = new Product("prod"+i,"description"+i,25,3);
            p.store(4);
            productsList.add(p);
        }
        PostOffice po = new PostOffice(12, productsList);

        //Sets maxNumberOfProducts to desired value
        assertTrue(po.setMaxNumberOfProducts(14));

        //Assert
        assertEquals(po.getNumberOfProducts(), 12);
        List<Product> products = po.getProducts();
        for(Product p : products){
            assertEquals(p.getCurrentQuantity(), 4);
            assertEquals(p.getPrice(), 25);
        }
        assertEquals(po.getMaxNumberOfProducts(), 14);
    }

    /*
     * TC5
     * p.name -> is unique
     * po.getNumberOfProducts()-> 2
     * po.maxNumberOfProducts -> 2
     * p.price -> 40
     * p.quantity -> 5
     * accepted
     * */
    @Test
    public void testValidPostOfficeWithUpdate(){
        List<Product> productsList = new ArrayList<Product>();
        for(int i = 1; i<=2; i++){
            Product p = new Product("prod"+i,"description"+i,20,3);
            p.store(3);
            productsList.add(p);
        }
        PostOffice po = new PostOffice(12, productsList);

        //Updates products for desired quantity and price
        for(int i = 1; i<=2; i++){
            assertTrue(po.update("prod"+i,40,5));
        }

        //Assert
        List<Product> products = po.getProducts();
        for(Product p : products){
            assertEquals(p.getCurrentQuantity(), 5);
            assertEquals(p.getPrice(), 40);
        }
        assertEquals(po.getNumberOfProducts(), 2);
        assertEquals(po.getMaxNumberOfProducts(), 2);
    }

    /*
     * TC6
     * p.name -> is unique
     * po.getNumberOfProducts()-> 5
     * po.maxNumberOfProducts -> 1
     * p.price -> 45
     * p.quantity -> 6
     * rejected
     * */
    @Test
    public void testInvalidValueforMaxNumberOfProducts(){
        List<Product> productsList = new ArrayList<Product>();
        for(int i = 1; i<=5; i++){
            Product p = new Product("prod"+i,"description"+i,45,3);
            p.store(6);
            productsList.add(p);
        }
        PostOffice po = new PostOffice(5, productsList);

        //Changes maxNumberOfProducts to invalid value
        assertFalse(po.setMaxNumberOfProducts(1));

        //Assert
        assertEquals(po.getMaxNumberOfProducts(), 5);
        assertEquals(po.getNumberOfProducts(), 5);
        List<Product> products = po.getProducts();
        for(Product p : products){
            assertEquals(p.getCurrentQuantity(), 6);
            assertEquals(p.getPrice(), 45);
        }
    }
}
