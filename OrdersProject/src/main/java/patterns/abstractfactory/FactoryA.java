package patterns.abstractfactory;

public class FactoryA implements AbstractFactory{
    @Override
    public IProductA createProductA(){
        return new ProductA1();
    }

    @Override
    public IProductB createProductB(){
        return new ProductB1();
    }

}
