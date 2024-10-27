package servicelayer;

import dao.impl.PaymentDAO;

public class PaymentService {
    private final PaymentDAO paymentDAO;

    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public boolean checkPaymentExists(int paymentId) {
        return paymentDAO.getAll().stream()
                .anyMatch(c -> c.getIdPayment() == paymentId);
    }
}
