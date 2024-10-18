package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ProductJAXB {
    private static final Logger logger = LogManager.getLogger(ProductJAXB.class);

    public static void marshal(Product product, String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Product.class);
            Marshaller mar = ctx.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(product, new File(path));

            logger.info(product.toString() + " correctly marshalled.");
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Product unmarshal(String path) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Product.class);
            Product product = (Product) ctx.createUnmarshaller().unmarshal(new File(path));
            logger.info(product.toString() + " correctly unmarshalled.");

            return product;
        } catch (JAXBException ex) {
            logger.error(ex.getMessage());
        }

        return null;
    }

}
