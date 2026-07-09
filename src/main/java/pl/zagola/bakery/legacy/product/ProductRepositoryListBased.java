package pl.zagola.bakery.legacy.product;

import pl.zagola.bakery.product.Product;

import java.util.List;

public class ProductRepositoryListBased implements ProductRepository {
    private List<Product> products;

    public ProductRepositoryListBased(List<Product> products) {
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