package patterns.proxy;

import model.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentProxy implements IPayment{
    private static final Logger logger = LogManager.getLogger(PaymentProxy.class);

    private Payment payment;
    private boolean isAuthorized;

    public PaymentProxy(Payment payment, boolean isAuthorized) {
        this.payment = payment;
        this.isAuthorized = isAuthorized;
    }

    @Override
    public void processPayment() {
        if(isAuthorized) {
            logger.info("Access authorized. Processing payment.");
            payment.processPayment();// Llamada a la lógica de pago real
        } else {
            logger.info("Access Denied: You do not have permissions to process the payment.");
        }
    }
}
