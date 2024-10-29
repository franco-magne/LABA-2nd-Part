package patterns.abstractfactory;

public class FactoryB implements AbstractFactory{
    @Override
    public IProductA createProductA(){
        return new ProductA2();
    }

    @Override
    public IProductB createProductB(){
        return new ProductB2();
    }

}
