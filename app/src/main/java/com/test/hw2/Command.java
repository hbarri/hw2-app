package com.test.hw2;

import android.view.View;

/**
 * Command interface class
 */
public interface Command {
    /**
     * method to execute command
     * @param rootView the view
     * @param c the Controller
     */
    void doIt(View rootView, Controller c);

    /**
     * method to undo command
     * @param c the Controller
     */
    void undoIt(Controller c);

    /**
     * method to redo command
     * @param c the Controller
     */
    void redoIt(Controller c);
}
