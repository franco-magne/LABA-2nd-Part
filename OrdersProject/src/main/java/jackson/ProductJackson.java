package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

public class ProductJackson {
    private static final Logger logger = LogManager.getLogger(ProductJackson.class);

    public static void convertToJSON(Product product, String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            writer.writeValue(file, product);
            logger.info(product.toString() + " converted to JSON");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Product convertToObject(String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(file, Product.class);
            logger.info(product.toString() + " converted to Object");

            return product;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
