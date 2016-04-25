package ua.kpi.tef.Model.Entities;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Денис on 24.04.2016.
 * This class is tied to user and certain game
 */
public class UserSession {
    private int upperBound;
    private int lowerBound;
    private int guessedNumber;
    private Queue<UserCheck> checks;

    //Constructors
    public UserSession(int upperBound, int lowerBound, int guessedNumber) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.guessedNumber = guessedNumber;
        checks = new LinkedList<>();
    }

    /**
     * This method returns all the actions user made before
     * @return actions in String*/
    public String actionsToString() {
        String res = "";
        for (UserCheck userCheck: checks) {
            res += userCheck.toString() + " \n";
        }
        return res;
    }

    /**
     * This method handle user action
     * @param input
     * @param compareResult */
    public void addAction(int input, CompareResults compareResult) {
        checks.add(new UserCheck(input, compareResult));
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }
}

/**
 * This class consists of int value and CompareResult enum
 * Describes user acton*/
class UserCheck {
    private int value;
    private CompareResults position;

    public UserCheck(int value, CompareResults position) {
        this.value = value;
        this.position = position;
    }

    /**
     * This method return action in String interpretation*/
    @Override
    public String toString() {
        return value + " " + position.name();
    }
}


