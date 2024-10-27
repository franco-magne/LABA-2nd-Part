package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import utils.xml.XMLDateAdapter;
import java.text.SimpleDateFormat;
import java.util.*;

@JsonRootName("order")
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @JsonProperty("idOrder")
    @XmlElement(name = "idOrder")
    private int idOrder;

    @JsonProperty("user")
    @XmlElementRef(name = "country", type = User.class)
    private User user;

    @JsonProperty("totalPrice")
    @XmlElement(name = "totalPrice")
    private double totalPrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    private Date orderDate;

    @JsonProperty("payment")
    @XmlElementRef(name = "country", type = Payment.class)
    private Payment payment;

    @JsonProperty("isPaid")
    @XmlElement(name = "isPaid")
    private boolean isPaid;

    @JsonProperty("productQuantityList")
    @XmlElement(name = "productQuantityList")
    private List<ProductQuantity> listProductQuantity;

    public Order() {}

    public Order(int idOrder, User user, double totalPrice, Date orderDate, Payment payment, boolean isPaid) {
        this.idOrder = idOrder;
        this.user = user;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.payment = payment;
        this.isPaid = isPaid;
        listProductQuantity =  new ArrayList<>();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "Order: { " +
                "idOrder = " + idOrder +
                ", user = " + user.getFirstName() + " " + user.getLastName() +
                ", total price = " + totalPrice +
                ", date = " + sdf.format(orderDate) +
                ", payment = " + payment.getMethod() +
                ", is paid = " + isPaid +
                ", list = " + listProductQuantity.toString() + " }";
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStringOrderDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(orderDate);
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }

    public List<ProductQuantity> getListProductQuantity() {
        return listProductQuantity;
    }

    public void setListProductQuantity(List<ProductQuantity> listProductQuantity) {
        this.listProductQuantity = listProductQuantity;
    }

    public void addProduct(Product product, int quantity) {
        this.listProductQuantity.add(new ProductQuantity(product, quantity));
    }
}
