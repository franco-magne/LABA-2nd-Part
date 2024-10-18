package model;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import utils.xml.XMLDateAdapter;
import java.text.SimpleDateFormat;
import java.util.*;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlElement(name = "idOrder")
    private int idOrder;

    @XmlElementRef(name = "country", type = User.class)
    private User user;

    @XmlElement(name = "totalPrice")
    private double totalPrice;

    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    private Date orderDate;

    @XmlElementRef(name = "country", type = Payment.class)
    private Payment payment;

    @XmlElement(name = "isPaid")
    private boolean isPaid;

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
