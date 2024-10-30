package patterns.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ForeignUser extends UserDecorator {
    private static final Logger logger = LogManager.getLogger(ForeignUser.class);

    public ForeignUser(IUser decoratedUser) {
        super(decoratedUser);
    }

    @Override
    public void assemble() {
        super.assemble();
        logger.info("Adding features for a Foreign User");
    }

    @Override
    public String getLocationType() {
        return "Foreign";
    }
}
