package servicelayer;

import dao.impl.OrderDAO;
import model.*;

import java.util.Date;
import java.util.List;

public class OrderService{
    private final OrderDAO orderDAO = new OrderDAO();
    // Logic regarding orders

    public Order getOrder(int id){
        return orderDAO.getByID(id);
    }

    public List<Order> listOrder(){
        return orderDAO.getAll();
    }

    public void createOrder(Order o, List<ProductQuantity> listOfProductsToOrder){
        int quantity = 0;
        double totalPrice = 0.0; // Get total price from each product in the list of products to order
        for (ProductQuantity pq:
                listOfProductsToOrder) {
            quantity = quantity + pq.getQuantity();
            totalPrice += pq.getProduct().getPrice() * pq.getQuantity();
        }
        o.setTotalPrice(totalPrice);
        orderDAO.insert(o); //sadly we don't have a mapper for order_product (and I will NOT do the entire thing), otherwise I could've code a loop to insert the appropiate amount of registries into that table, I guess we just do one-product orders for now.
    }

    public void updateOrder(Order o){
        orderDAO.update(o);
    }

    public void deleteOrder(Order o){
        orderDAO.delete(o);
    }
}

