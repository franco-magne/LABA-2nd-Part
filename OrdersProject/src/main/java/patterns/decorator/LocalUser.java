package patterns.decorator;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocalUser extends UserDecorator {
    private static final Logger logger = LogManager.getLogger(LocalUser.class);
    public LocalUser(IUser decoratedUser) {
        super(decoratedUser);
    }

    @Override
    public void assemble() {
        super.assemble();
        logger.info("Adding features for a Local User");
    }

    @Override
    public String getLocationType() {
        return "Local";
    }

}
