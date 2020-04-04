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
        Product p1 = new Product("prod1","description1",1,1);
        p1.store(1);
        Product p2 = new Product("prod2","description2",1,1);
        p2.store(1);

        List<Product> products = new ArrayList<Product>();
        products.add(p1);
        products.add(p2);

        PostOffice po = new PostOffice(4, products);

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 4);
        Assert.assertEquals(po.getNumberOfProducts(), 2);
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
    public void testCtorWhenProductNameIsNotUnique(){
        Product p1 = new Product("prod","description1",2,1);
        p1.store(2);
        Product p2 = new Product("prod","description2",2,1);
        p2.store(2);
        Product p3 = new Product("prod","description3",2,1);
        p3.store(2);

        List<Product> products = new ArrayList<Product>();
        products.add(p1);
        products.add(p2);
        products.add(p3);

        PostOffice po = new PostOffice(5, products);

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 5);
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
        List<Product> products = new ArrayList<Product>();

        for(int i = 1; i<=11; i++){
            Product p = new Product("prod"+i,"description"+i,15,2);
            p.store(3);
            products.add(p);
        }

        PostOffice po = new PostOffice(13, products);

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 13);
        Assert.assertEquals(po.getNumberOfProducts(), 11);
    }

    /*
     * TC4
     * p.name -> is unique
     * po.getNumberOfProducts()-> 12
     * po.maxNumberOfProducts -> 7
     * p.price -> 25
     * p.quantity -> 4
     * fails
     * */
    @Test
    public void testCase4(){
        List<Product> products = new ArrayList<Product>();

        for(int i = 1; i<=12; i++){
            Product p = new Product("prod"+i,"description"+i,25,3);
            p.store(4);
            products.add(p);
        }

        PostOffice po = new PostOffice(7, products);

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 7);
    }

    /*
     * TC5
     * p.name -> is unique
     * po.getNumberOfProducts()-> 4
     * po.maxNumberOfProducts -> 2
     * p.price -> 40
     * p.quantity -> 5
     * fails
     * */
    @Test
    public void testCase5(){
        List<Product> products = new ArrayList<Product>();

        for(int i = 1; i<=4; i++){
            Product p = new Product("prod"+i,"description"+i,40,3);
            p.store(5);
            products.add(p);
        }

        PostOffice po = new PostOffice(2, products);

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 2);
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
    public void testCase6(){
        List<Product> products = new ArrayList<Product>();

        for(int i = 1; i<=5; i++){
            Product p = new Product("prod"+i,"description"+i,45,3);
            p.store(6);
            products.add(p);
        }

        PostOffice po = new PostOffice(1, products);

        //Assert
        Assert.assertEquals(po.getMaxNumberOfProducts(), 1);
    }
}
