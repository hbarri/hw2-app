package com.test.hw2;

import java.util.ArrayList;
import java.util.List;

/**
 * CommandQ class to keep track of commands executed
 */
public class CommandQ {
    //list of commands executed
    private static List<Command> cmdStack = new ArrayList<>();
    private static int currentInd = -1;
    private static int maxInd = -1;

    /**
     * method to push commands into stack
     * @param c the Command to push
     */
    public static void push(Command c) {
        //increment index and push command
        currentInd++;
        cmdStack.add(currentInd, c);
        //update max index
        maxInd = currentInd;
    }

    /**
     * method to return latest command
     * @return command
     */
    public static Command getCommand() {
        return cmdStack.get(maxInd);
    }

    /**
     * method to undo latest command
     * @param c the Controller
     */
    public static void undo(Controller c) {
        //gets latest command to undo
        cmdStack.get(currentInd).undoIt(c);
        //decrements current index
        currentInd--;
    }

    /**
     * method to redo latest command undone
     * @param c the Controller
     */
    public static void redo(Controller c) {
        //checks there are commands to redo
        if (currentInd < maxInd) {
            //increments current index
            currentInd++;
            //redoes command
            cmdStack.get(currentInd).redoIt(c);
        }
    }
}
