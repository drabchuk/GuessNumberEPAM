package ua.kpi.tef;

import ua.kpi.tef.Controller.Controller;
import ua.kpi.tef.Model.Model;
import ua.kpi.tef.View.View;

/**
 * Created by Denis Drabchuck on 22.04.2016.
 */
public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }

}
