package ua.kpi.tef.View;


/**
 * Created by Denis Drabchuck on 24.04.2016.
 */
public class View {
    // Text's constants
    public static final String GREETING = "Hello!";
    public static final String DESCRIPTION = "Let's play game.\nI think of some number from 0 to 100.\nYou have to guess my number.\nStart guessing, I'll tel you if my number bigger than your or less.";
    public static final String INPUT_INT_START = "Input INT value from ";
    public static final String INPUT_INT_TO = " to ";
    public static final String INPUT_INT_END = " = ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String CONGRATULATIONS = "Congratulations! You guessed!";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageWithTwoInts(String mes1, int value1, String mes2, int value2, String mes3) {
        System.out.println(mes1 + value1 + mes2 + value2 + mes3);
    }
}
