package pl.zagola.bakery;

import java.util.List;

public class BakeryProductManagement implements BakeryProductRepository {
    private List<BakeryProduct> products;

    public BakeryProductManagement(List<BakeryProduct> products) {
        this.products = products;
    }

    @Override
    public List<BakeryProduct> findAll() {
        return List.of();
    }

    @Override
    public BakeryProduct findByName(String name) {
        return null;
    }

    @Override
    public BakeryProduct findById(int id) {
        return null;
    }

    @Override
    public void changeCustom(BakeryProduct bakeryProduct, String customization) {

    }

    @Override
    public void removeProduct(BakeryProduct bakeryProductToBeRemoved) {

    }
}
