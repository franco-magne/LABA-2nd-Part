package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

public class OrderJackson {
    private static final Logger logger = LogManager.getLogger(OrderJackson.class);

    public static void convertToJSON(Order order, String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            writer.writeValue(file, order);
            logger.info(order.toString() + " converted to JSON");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Order convertToObject(String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            Order order = mapper.readValue(file, Order.class);
            logger.info(order.toString() + " converted to Object");

            return order;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
