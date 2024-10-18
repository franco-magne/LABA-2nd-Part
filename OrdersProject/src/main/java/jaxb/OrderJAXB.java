package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;

public class OrderJAXB {
    private static final Logger logger = LogManager.getLogger(OrderJAXB.class);

    public static void marshal(Order order, String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Order.class);
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(order, new File(path));

            logger.info(order.toString() + " correctly marshalled.");
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Order unmarshal(String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Order.class);
            Order order = (Order) ctx.createUnmarshaller().unmarshal(new File(path));
            logger.info(order.toString() + " correctly unmarshalled.");

            return order;
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }


}
