package model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int idOrder;
    private User user;
    private double totalPrice;
    private String orderDate;
    private Payment payment;
    private boolean isPaid;
    private Map<Product, Integer> listProductQuantity;

    public Order(int idOrder, User user, double totalPrice, String orderDate, Payment payment, boolean isPaid) {
        this.idOrder = idOrder;
        this.user = user;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.payment = payment;
        this.isPaid = isPaid;
        listProductQuantity =  new HashMap<>();
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
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

    public Map<Product, Integer> getListProductQuantity() {
        return listProductQuantity;
    }

    public void setListProductQuantity(Map<Product, Integer> listProductQuantity) {
        this.listProductQuantity = listProductQuantity;
    }
}
