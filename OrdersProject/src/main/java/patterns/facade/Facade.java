package patterns.facade;

public class Facade {
    private Subsystem1 subSys1;
    private Subsystem2 subSys2;
    private Subsystem3 subSys3;

    public Facade(){
        subSys1 = new Subsystem1();
        subSys2 = new Subsystem2();
        subSys3 = new Subsystem3();
    }

    public Object complexOperation() {
        Object result1 = subSys1.operation1();
        Object result2 = subSys2.operation2();
        Object result3 = subSys3.operation3();
        return result1 + ", " + result2 + ", " + result3;
    }

    public Object simpleOperation() {
        return subSys1.operation1();
    }
}
