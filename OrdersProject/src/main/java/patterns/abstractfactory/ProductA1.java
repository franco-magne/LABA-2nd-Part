package patterns.abstractfactory;
public class ProductA1 implements IProductA{
    @Override
    public Object createProduct(){
        return "Product A1";
    }
}
