/**
 * This class represents a calculator that is able to sum and divide two Integer numbers.
 * Each calculator has a name and keeps the number of operations executed without errors.
 **/

package ap;
import java.util.*;

public class PostOffice {
    public PostOffice(int maxNumberOfProducts, List<Product> products) { /* .... */ }

    // adds a new product to this post office.
    public boolean addNewProduct(Product p) { /* .... */ }

    // updates quantity and/or price of the given product
    public boolean update(String productName, int newPrice, int newQuantity) { /* .... */ }

    // removes a product from this post office
    public boolean removeProduct(String productName) { /* .... */ }

    public boolean setMaxNumberOfProducts(int newMaxQuantity) { /* .... */ }

    // accessor methods
    public List<Product> getProducts() { /* .... */ }

    public int getMaxNumberOfProducts() { /* .... */ }

    public int getNumberOfProducts() { /* .... */ }
}
