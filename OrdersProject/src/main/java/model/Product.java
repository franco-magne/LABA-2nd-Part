package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.*;

@JsonRootName("product")
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    @JsonProperty("idProduct")
    @XmlElement(name = "idProduct")
    private int idProduct;

    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;

    @JsonProperty("description")
    @XmlElement(name = "description")
    private String description;

    @JsonProperty("price")
    @XmlElement(name = "price")
    private double price;

    @JsonProperty("stock")
    @XmlElement(name = "stock")
    private int stock;

    @JsonProperty("category")
    @XmlElementRef(name = "category", type = Category.class)
    private Category category;

    @JsonProperty("store")
    @XmlElementRef(name = "store", type = Store.class) //edit: it was "category"
    private Store store;

    public Product() {}

    public Product(int idProduct, String name, String description, double price, int stock, Category category, Store store) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.store = store;
    }

    @Override
    public String toString() {
        return "Store: { " +
                "idProduct = " + idProduct +
                ", name = " + name +
                ", description = " + description +
                ", price = " + price +
                ", stock = " + stock +
                ", category = " + category.getName() +
                ", store = " + store.getName() + " }";
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
