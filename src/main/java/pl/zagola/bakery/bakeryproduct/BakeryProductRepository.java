
package pl.zagola.bakery.bakeryproduct;

import java.util.List;

public interface BakeryProductRepository {
    List<BakeryProduct> findAll();

    BakeryProduct findByName(String name);

    BakeryProduct findById(int id);

    void changeCustom(BakeryProduct bakeryProduct, String customization);


    void removeProduct(BakeryProduct bakeryProductToBeRemoved);

}