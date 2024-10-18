package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Category;
import model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class CategoryJAXB {
    private static final Logger logger = LogManager.getLogger(CategoryJAXB.class);

    public static void marshal(Category category, String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Category.class);
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(category, new File(path));

            logger.info(category.toString() + " correctly marshalled.");
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Category unmarshal(String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Category.class);
            Category category = (Category) ctx.createUnmarshaller().unmarshal(new File(path));
            logger.info(category.toString() + " correctly unmarshalled.");

            return category;
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
