package patterns.abstractfactory;

public class ProductA2 implements IProductA{
    @Override
    public Object createProduct(){
        return "Product A2";
    }
}
