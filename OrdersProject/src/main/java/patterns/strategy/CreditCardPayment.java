package patterns.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditCardPayment implements IPaymentStrategy {
    private static final Logger logger = LogManager.getLogger(CreditCardPayment.class);

    @Override
    public void pay(double amount) {
        logger.info("Paid {} using Credit Card.", amount);
    }
}
