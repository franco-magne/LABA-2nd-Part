package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;

public class PaymentJAXB {
    private static final Logger logger = LogManager.getLogger(PaymentJAXB.class);

    public static void marshal(Payment payment, String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Payment.class);
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(payment, new File(path));

            logger.info(payment.toString() + " correctly marshalled.");
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Payment unmarshal(String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Payment.class);
            Payment payment = (Payment) ctx.createUnmarshaller().unmarshal(new File(path));
            logger.info(payment.toString() + " correctly unmarshalled.");

            return payment;
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
