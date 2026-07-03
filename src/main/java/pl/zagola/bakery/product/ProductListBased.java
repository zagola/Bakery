package pl.zagola.bakery.product;

import java.util.List;

public class ProductListBased implements ProductRepository {
    private List<Product> products;

    public ProductListBased(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void changeCustom(Product product, String customization) {

    }

    @Override
    public void removeProduct(Product productToBeRemoved) {
    }
}