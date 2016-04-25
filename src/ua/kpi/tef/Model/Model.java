package ua.kpi.tef.Model;

import ua.kpi.tef.Model.Entities.CompareResults;
import ua.kpi.tef.Model.Entities.UserSession;

/**
 * Created by Denis Drabchuck on 24.04.2016.
 */
public class Model {
    public final int RAND_MAX = 100;
    public final int RAND_MIN = 0;

    // Program logic

    /**
     * This method compares input value to guessed number in user session and change boundaries respectively
     * @param inputValue
     * @param userSession
     * @return compare result*/
    public CompareResults handleUserAction(UserSession userSession, int inputValue) {
        int guessedNumber = userSession.getGuessedNumber();
        if(inputValue == guessedNumber) {
            userSession.addAction(inputValue, CompareResults.EQUAL);
            return CompareResults.EQUAL;
        } else {
            if(inputValue < guessedNumber) {
                userSession.addAction(inputValue, CompareResults.LOWER);
                userSession.setLowerBound(inputValue);
                return CompareResults.LOWER;
            } else {
                userSession.addAction(inputValue, CompareResults.BIGGER);
                userSession.setUpperBound(inputValue);
                return CompareResults.BIGGER;
            }
        }
    }

    /**
     * This method create new game session and guess number
     * @return user session*/
    public UserSession initUserSession() {
        return new UserSession(RAND_MAX, RAND_MIN, rand(RAND_MIN, RAND_MAX));
    }

    /**
     * This method return random number from lower to upper
     * @param lower
     * @param upper
     * @return random number*/
    private int rand(int lower, int upper) {
        return lower + (int)(Math.random() * ((upper - lower) + 1));
    }

    /**
     * This method return random number from 0 to RAND_MAX
     * @return random number*/
    private int rand() {
        return (int)(Math.random()*(RAND_MAX + 1));
    }

}
