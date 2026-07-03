
package pl.zagola.bakery.product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findByName(String name);

    Product findById(int id);

    void changeCustom(Product product, String customization);

    void removeProduct(Product productToBeRemoved);
}