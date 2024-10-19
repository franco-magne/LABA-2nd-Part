package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;

public class CountryJackson {
    private static final Logger logger = LogManager.getLogger(CountryJackson.class);

    public static void convertToJSON(Country country, String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

            writer.writeValue(file, country);
            logger.info(country.toString() + " converted to JSON");
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Country convertToObject(String path) {
        try {
            File file = new File(path);
            ObjectMapper mapper = new ObjectMapper();
            Country country = mapper.readValue(file, Country.class);
            logger.info(country.toString() + " converted to Object");

            return country;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
