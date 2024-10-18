package jaxb;

import model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;

public class CountryJAXB {
    private static final Logger logger = LogManager.getLogger(CountryJAXB.class);

    public static void marshal(Country country, String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Country.class);
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(country, new File(path));

            logger.info(country.toString() + " correctly marshalled.");
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Country unmarshal(String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Country.class);
            Country country = (Country) ctx.createUnmarshaller().unmarshal(new File(path));
            logger.info(country.toString() + " correctly unmarshalled.");

            return country;
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
