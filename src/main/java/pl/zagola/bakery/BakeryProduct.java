package pl.zagola.bakery;

public class BakeryProduct {
    private String name;
    private double price;
    private String customizations;
    private int stockQuantity;
    private String wholesalerOrder;
    private String merchandising;

    public BakeryProduct(String name, double price, int stockQuantity, String customizations) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.customizations = customizations;
    }
}