package ua.kpi.tef.Controller;

import ua.kpi.tef.Model.Entities.CompareResults;
import ua.kpi.tef.Model.Entities.UserSession;
import ua.kpi.tef.Model.Model;
import ua.kpi.tef.View.View;

import java.util.Scanner;

/**
 * Created by Denis Drabchuck on 24.04.2016.
 */
public class Controller {

    // Constructor
    Model model;
    View view;

    //Controllers
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        UserSession userSession = model.initUserSession();

        view.printMessage(view.GREETING);
        view.printMessage(view.DESCRIPTION);

        CompareResults compareResult;

        do {
            compareResult = model.handleUserAction(userSession, inputIntValueWithScannerInTheRange(sc, userSession.getLowerBound(), userSession.getUpperBound()));
            view.printMessage(compareResult.name());
        } while(compareResult != CompareResults.EQUAL);
        view.printMessage(view.CONGRATULATIONS);
        view.printMessage(userSession.actionsToString());
    }

    public int inputIntValueWithScannerInTheRange(Scanner sc, int lowerBound, int upperBound) {
        view.printMessageWithTwoInts(view.INPUT_INT_START, lowerBound, view.INPUT_INT_TO, upperBound, view.INPUT_INT_END);
        int input;
        do {
            while (!sc.hasNextInt()) {
                view.printMessage(view.WRONG_INPUT_DATA);
                sc.next();
            }
            input = sc.nextInt();
            if(isInRange(input, lowerBound, upperBound))
                return input;
            view.printMessage(view.WRONG_INPUT_DATA);
        } while (true);
    }

    private boolean isInRange(int check, int lowerBound, int upperBound) {
        return check >= lowerBound && check <= upperBound;
    }
}
