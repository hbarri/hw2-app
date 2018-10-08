package com.test.hw2;

import android.view.View;
import android.widget.NumberPicker;

/**
 * Change minute command class
 * implements Command interface
 */
public class ChangeMinCmd implements Command {
    private int prevMin;
    private int newMin;

    /**
     * method to execute command to change the minute
     * @param rootView the view
     * @param c the Controller
     */
    @Override
    public void doIt(View rootView, Controller c) {
        //gets previous minute
        prevMin = c.getMin();
        //gets new value from number picker
        NumberPicker np = (NumberPicker) rootView.findViewById(R.id.npMin);
        //sets new value
        newMin = np.getValue();
        c.setMin(newMin);
    }

    /**
     * method redo command
     * @param c the Controller
     */
    @Override
    public void redoIt(Controller c) {
        //sets new minute again
        c.setMin(newMin);
    }

    /**
     * method undo command
     * @param c the Controller
     */
    @Override
    public void undoIt(Controller c) {
        //sets minute back to previous minute
        c.setMin(prevMin);
    }
}
