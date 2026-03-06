package pl.zagola.bakery;

public class BakeryProduct {
    private String name;
    private double price;
    private String customizations;
    private int stockQuantity;
    private String wholesalerOrder;
    private String merchandising;
    private Integer productId;

    public BakeryProduct(String name, double price, int stockQuantity, String customizations, Integer productId) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.customizations = customizations;
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}