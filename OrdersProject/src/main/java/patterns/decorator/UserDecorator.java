package patterns.decorator;

public abstract class UserDecorator implements IUser {
    protected IUser decoratedUser;

    public UserDecorator(IUser decoratedUser) {
        this.decoratedUser = decoratedUser;
    }

    @Override
    public void assemble() {
        this.decoratedUser.assemble();
    }

    @Override
    public String getLocationType() {
        return decoratedUser.getLocationType();
    }
}
