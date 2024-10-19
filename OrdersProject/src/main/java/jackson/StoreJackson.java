package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

public class StoreJackson {
    private static final Logger logger = LogManager.getLogger(StoreJackson.class);

    public static void convertToJSON(Store store, String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            writer.writeValue(file, store);
            logger.info(store.toString() + " converted to JSON");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Store convertToObject(String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            Store store = mapper.readValue(file, Store.class);
            logger.info(store.toString() + " converted to Object");

            return store;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
