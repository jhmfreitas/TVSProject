package ap;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.*;

@Test
public class TestPostOffice {

    @Test
    public void test1(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("prod1","description1",1,1));
        products.add(new Product("prod2","description2",1,1));
        PostOffice po = new PostOffice(4, products);
        po.setMaxNumberOfProducts(4);
    }

    @Test
    public void testCtorWhenProductNameIsNotUnique(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("prod","description1",2,1));
        products.add(new Product("prod","description2",2,1));
        products.add(new Product("prod","description3",2,1));
        PostOffice po = new PostOffice(4, products);
        po.setMaxNumberOfProducts(5);
    }
}
