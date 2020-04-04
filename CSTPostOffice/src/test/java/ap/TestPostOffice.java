package ap;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

@Test
public class TestPostOffice {

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
        po.setMaxNumberOfProducts(4);
    }

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

        PostOffice po = new PostOffice(4, products);
        po.setMaxNumberOfProducts(5);
    }
}
