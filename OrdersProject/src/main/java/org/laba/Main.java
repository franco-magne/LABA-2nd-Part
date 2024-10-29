package org.laba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import patterns.abstractfactory.*;
import patterns.facade.Facade;
import patterns.factory.Factory;
import patterns.mvc.MVC;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        /*
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

        // Json parsing example
        OrderJackson.convertToJSON(ord, "src/main/resources/json/order.json");
        Order orderRecover = OrderJackson.convertToObject("src/main/resources/json/order.json");
         */


        // TESTING IF IT RUNS OR NOT
        /*
        CountryService countryService = new CountryService();
        StoreService storeService = new StoreService();
        UserService userService = new UserService();
        ProductService productService = new ProductService();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService();
        CategoryService categoryService = new CategoryService();

        // DISPLAYING DATA
        logger.info("LOADING SOME DATA FROM THE DATABASE...");
        Country c = countryService.getCountry(1);
        logger.info("LOADED COUNTRY '" + c.getName() + "' FROM DATABASE"); // It should display 'USA'

        Store s = storeService.getStore(1);
        logger.info("LOADED STORE '" + s.getName() + "' FROM DATABASE"); // It should display 'Just Sports'

        User u = userService.getUser(1);
        logger.info("LOADED USER '" + u.getFirstName() + "' FROM DATABASE"); // It should display 'Franco'

        Category category = categoryService.getCategory(7);
        logger.info("LOADED CATEGORY '" + category.getName() + "' FROM DATABASE"); // It should display 'Automotive'

        Payment payment = paymentService.getPayment(1);
        logger.info("LOADED PAYMENT '" + payment.getMethod() + "' FROM DATABASE"); // It should display 'Cash'

        // Creating a product and inserting it into the database (auto-incremental index)
        Product p = new Product();
        p.setIdProduct(1);
        p.setName("Toyota AE86");
        p.setDescription("It's a car from Initial D");
        p.setCategory(category);
        p.setPrice(14000.0);
        p.setStock(1);
        p.setStore(s);
        productService.createProduct(p);
        logger.info("INSERTED PRODUCT '" + p.getName() + "' INTO THE DATABASE");

        Order o = new Order();
        o.setIdOrder(1);
        o.setIsPaid(true);
        o.setPayment(payment);
        o.setUser(u);
        Date d = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        o.setOrderDate(d);

        List<ProductQuantity> listOfProductsToOrder = new ArrayList<>();

        int quantity = 1;
        ProductQuantity pq = new ProductQuantity(p, quantity);
        listOfProductsToOrder.add(pq);

        orderService.createOrder(o, listOfProductsToOrder);
        logger.info("INSERTED ORDER NO." + o.getIdOrder() + " INTO THE DATABASE"); // Can't create multiple order_product registries for each hypothetical product in the ListOfProductsToOrder because we don't have the mapper for it YET (I think (I really, really tried guys ToT))
        */

        Factory genericFactory = new Factory();
        logger.info("-------------{Factory}-------------");

        Object obj1 = genericFactory.createObject("String");
        obj1 = "A string object.";
        logger.info("Used Factory to create 'obj1' String object with value '" + obj1 + "'");

        Object obj2 = genericFactory.createObject("Integer");
        logger.info("Used Factory to create 'obj2' Integer object with value = " + obj2);


        AbstractFactory factoryA = new FactoryA();
        AbstractFactory factoryB = new FactoryB();
        logger.info("-------------{Abstract Factory}-------------");

        IProductA productA1 = factoryA.createProductA();
        logger.info("Used FactoryA to create productA1..");
        logger.info("Output of productA1.createProduct(): "+productA1.createProduct());

        IProductB productB1 = factoryA.createProductB();
        logger.info("Used FactoryA to create productB1..");
        logger.info("Output of productB1.createProduct(): "+productB1.createProduct());

        IProductA productA2 = factoryB.createProductA();
        logger.info("Used FactoryB to create productA2..");
        logger.info("Output of productA2.createProduct(): "+productA2.createProduct());

        IProductB productB2 =  factoryB.createProductB();
        logger.info("Used FactoryB to create productB2..");
        logger.info("Output of productB2.createProduct(): "+productB2.createProduct());


        Facade facade = new Facade();
        logger.info("-------------{Facade}-------------");

        Object complexRequirementObjectResult = facade.complexOperation();
        logger.info("The facade executed a complex method and got: " + complexRequirementObjectResult);

        Object simpleRequirementObjectResult = facade.simpleOperation();
        logger.info("The facade executed a simple method and got: " + simpleRequirementObjectResult);

        MVC mvc = new MVC();
        logger.info("-------------{MVC}-------------");
        boolean enterMVCDemo = true; // Cambien esto a "false" para que el menu no los moleste al testear su codigo en el main ;)
        if (enterMVCDemo){
            logger.info("ENTERING TO THE MVC DEMO MENU...");
            mvc.showMenu();
        }
        else{
            logger.info("MVC DEMO WAS SKIPPED");
        }

        // Su codigo



    }
}
