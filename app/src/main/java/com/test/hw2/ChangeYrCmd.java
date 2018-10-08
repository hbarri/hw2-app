package com.test.hw2;

import android.view.View;
import android.widget.EditText;

/**
 * Change year command class
 * implements Command interface
 */
public class ChangeYrCmd implements Command {
    private int prevYr;
    private int newYr;

    /**
     * method to execute command to change the year
     * @param rootView the view
     * @param c the Controller
     */
    @Override
    public void doIt(View rootView, Controller c) {
        //gets old year
        prevYr = c.getYear();
        //gets new value from user
        EditText editText = rootView.findViewById(R.id.changeYrText);
        //sets new value
        newYr = Integer.parseInt(editText.getText().toString());
        c.setYear(newYr);
    }

    /**
     * method redo command
     * @param c the Controller
     */
    @Override
    public void redoIt(Controller c) {
        //sets new year again
        c.setYear(newYr);
    }

    /**
     * method undo command
     * @param c the Controller
     */
    @Override
    public void undoIt(Controller c) {
        //sets old year
        c.setYear(prevYr);
    }
}
