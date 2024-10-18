package org.laba;

import dao.impl.CategoryDAO;
import jaxb.OrderJAXB;
import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import servicelayer.CategoryService;
import utils.xml.StAXParser;
import utils.xml.XMLValidator;
import java.util.Date;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        // Executing getAll from CategoryDAO
        List<Category> categoryList = new CategoryDAO().getAll();
        logger.info(categoryList);

        // Executing the Service Layer of Category
        CategoryService categoryService = new CategoryService(new CategoryDAO());
        logger.info(categoryService.checkCategoryExists("Books"));

        // Validating the XSD file against the XML
        String xsdPath = "src/main/resources/xsd/schema.xsd";
        String xmlPath = "src/main/resources/xml/schema.xml";
        XMLValidator.validateXMLSchemaWithXSD(xsdPath, xmlPath);

        // StAX parsing example
        StAXParser.parseXMLFileWithStAX(xmlPath);

        // Classes needed for marshal & unmarshal
        Country uk = new Country(9, "UK");
        Payment cash = new Payment(1, "Cash");
        Category tech = new Category(4, "Tech");
        Store hp = new Store(10, "HP", "Av. High Park", 80, uk);
        Product laptop = new Product(15, "Laptop HP", "16 GB", 1500, 15, tech, hp);
        Product printer = new Product(16, "Epson", "With WiFi", 500, 50, tech, hp);
        User fran = new User(6, "Fran", "Mg", "@mail", "Home", "8888", uk);

        Order ord = new Order(22, fran, 5000, new Date(), cash, true);
        ord.addProduct(laptop, 3);
        ord.addProduct(printer, 1);

        // Marshal and unmarshal example
        OrderJAXB.marshal(ord, "src/main/resources/jaxbxml/order.xml");
        Order order = OrderJAXB.unmarshal("src/main/resources/jaxbxml/order.xml");

    }
}
