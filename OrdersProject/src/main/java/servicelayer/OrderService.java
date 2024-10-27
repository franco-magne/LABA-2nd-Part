package servicelayer;

import dao.impl.OrderDAO;

public class OrderService {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public boolean checkOrderExists(int orderId) {
        return orderDAO.getAll().stream()
                .anyMatch(c -> c.getIdOrder() == orderId);
    }
}
