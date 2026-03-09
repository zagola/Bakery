package pl.zagola.bakery;

public class BakeryProduct {
    private String name;
    private double price;
    private int id;


    public BakeryProduct(String name, double price, int stockQuantity, String customizations, Integer productId) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}

//  private String customizations;
//    private int stockQuantity;
//    private String wholesalerOrder;
//    private String merchandising;