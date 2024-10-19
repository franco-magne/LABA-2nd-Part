package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.*;

@JsonRootName("productQuantity")
@XmlRootElement(name = "productQuantity")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductQuantity {

    @JsonProperty("product")
    @XmlElementRef(name = "product", type = Product.class)
    private Product product;

    @JsonProperty("quantity")
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
