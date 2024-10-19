package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

public class PaymentJackson {
    private static final Logger logger = LogManager.getLogger(PaymentJackson.class);

    public static void convertToJSON(Payment payment, String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            writer.writeValue(file, payment);
            logger.info(payment.toString() + " converted to JSON");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Payment convertToObject(String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            Payment payment = mapper.readValue(file, Payment.class);
            logger.info(payment.toString() + " converted to Object");

            return payment;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
