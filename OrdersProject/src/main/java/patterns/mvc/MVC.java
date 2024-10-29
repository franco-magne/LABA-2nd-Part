package patterns.mvc;

import patterns.mvc.controller.Controller;
import patterns.mvc.model.SampleModel;
import patterns.mvc.view.MainMenu;

public class MVC {
    public void showMenu() {
        SampleModel model = new SampleModel();
        Controller controller = new Controller(model);
        MainMenu view = new MainMenu(controller);
        view.showMenu();
    }
}
