package patterns.abstractfactory;

public class ProductB1 implements IProductB {
    @Override
    public Object createProduct() {
        return "Product B1";
    }
}
