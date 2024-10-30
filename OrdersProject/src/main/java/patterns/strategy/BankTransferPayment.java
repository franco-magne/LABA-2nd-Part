package patterns.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankTransferPayment implements IPaymentStrategy{
    private static final Logger logger = LogManager.getLogger(BankTransferPayment.class);

    @Override
    public void pay(double amount) {
        logger.info("Paid {} using  Bank Transfer.", amount);
    }
}
