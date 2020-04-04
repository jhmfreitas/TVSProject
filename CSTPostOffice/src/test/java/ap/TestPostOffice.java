package ap;

import org.testng.Assert;
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
    public void testValidPostOffice(){
        PostOffice po = new PostOffice(4, new ArrayList<Product>());

        //Adds products
        Product p1 = new Product("prod1","description1",1,1);
        p1.store(1);
        Product p2 = new Product("prod2","description2",1,1);
        p2.store(1);
        Assert.assertTrue(po.addNewProduct(p1));
        Assert.assertTrue(po.addNewProduct(p2));

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 4);
        Assert.assertEquals(po.getNumberOfProducts(), 2);
        List<Product> products = po.getProducts();
        for(Product p : products){
            Assert.assertEquals(p.getCurrentQuantity(), 1);
            Assert.assertEquals(p.getPrice(), 1);
        }
    }

    /*
     * TC2
     * p.name -> not unique
     * po.getNumberOfProducts()-> 3
     * po.maxNumberOfProducts -> 5
     * p.price -> 2
     * p.quantity -> 2
     * fails
     * */
    @Test
    public void testWhenProductNameIsNotUnique(){
        PostOffice po = new PostOffice(5, new ArrayList<Product>());

        //Adds products
        for(int i = 1; i<=2; i++){
            Product p = new Product("prod"+i,"description"+i,2,1);
            p.store(2);
            Assert.assertTrue(po.addNewProduct(p));
        }
        Product p3 = new Product("prod1","description3",2,1);
        p3.store(2);
        Assert.assertFalse(po.addNewProduct(p3));

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 5);
        Assert.assertEquals(po.getNumberOfProducts(),2);
        List<Product> products = po.getProducts();
        for(Product p : products){
            Assert.assertEquals(p.getCurrentQuantity(), 2);
            Assert.assertEquals(p.getPrice(), 2);
        }
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
    public void testCase3(){
        PostOffice po = new PostOffice(13, new ArrayList<Product>());

        //Adds products
        for(int i = 1; i<=11; i++){
            Product p = new Product("prod"+i,"description"+i,15,2);
            p.store(3);
            Assert.assertTrue(po.addNewProduct(p));
        }

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 13);
        Assert.assertEquals(po.getNumberOfProducts(), 11);
        List<Product> products = po.getProducts();
        for(Product p : products){
            Assert.assertEquals(p.getCurrentQuantity(), 3);
            Assert.assertEquals(p.getPrice(), 15);
        }
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
    public void testCase4(){
        PostOffice po = new PostOffice(14, new ArrayList<Product>());

        //Adds products
        for(int i = 1; i<=12; i++){
            Product p = new Product("prod"+i,"description"+i,25,3);
            p.store(4);
            Assert.assertTrue(po.addNewProduct(p));
        }

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 14);
        Assert.assertEquals(po.getNumberOfProducts(), 12);
        List<Product> products = po.getProducts();
        for(Product p : products){
            Assert.assertEquals(p.getCurrentQuantity(), 4);
            Assert.assertEquals(p.getPrice(), 25);
        }
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
    public void testCase5(){
        PostOffice po = new PostOffice(2, new ArrayList<Product>());

        //Adds products
        for(int i = 1; i<=2; i++){
            Product p = new Product("prod"+i,"description"+i,40,3);
            p.store(5);
            Assert.assertTrue(po.addNewProduct(p));
        }

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 2);
        Assert.assertEquals(po.getNumberOfProducts(), 2);
        List<Product> products = po.getProducts();
        for(Product p : products){
            Assert.assertEquals(p.getCurrentQuantity(), 5);
            Assert.assertEquals(p.getPrice(), 40);
        }
    }

    /*
     * TC6
     * p.name -> is unique
     * po.getNumberOfProducts()-> 5
     * po.maxNumberOfProducts -> 1
     * p.price -> 45
     * p.quantity -> 6
     * fails
     * */
    @Test
    public void testInavlidValueforMaxNumberOfProducts(){
        PostOffice po = new PostOffice(5, new ArrayList<Product>());

        //Adds products
        for(int i = 1; i<=5; i++){
            Product p = new Product("prod"+i,"description"+i,45,3);
            p.store(6);
            Assert.assertTrue(po.addNewProduct(p));
        }
        //Changes maxNumberOfProducts to invalid value
        Assert.assertFalse(po.setMaxNumberOfProducts(1));

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 5);
        Assert.assertEquals(po.getNumberOfProducts(), 5);
        List<Product> products = po.getProducts();
        for(Product p : products){
            Assert.assertEquals(p.getCurrentQuantity(), 6);
            Assert.assertEquals(p.getPrice(), 45);
        }
    }
}
