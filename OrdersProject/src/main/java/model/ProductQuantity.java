package model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "productQuantity")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductQuantity {

    @XmlElementRef(name = "product", type = Product.class)
    private Product product;

    @XmlElement(name = "quantity")
    private int quantity;

    public ProductQuantity() {};

    public ProductQuantity(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: { " +
                "name = " + product.getName() +
                ", quantity = " + quantity + " }";
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
