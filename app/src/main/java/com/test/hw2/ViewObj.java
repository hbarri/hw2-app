package com.test.hw2;

/**
 * interface ViewObj to allow views to implement
 */
public interface ViewObj {
    /**
     * constructor to set controller
     * @param c
     */
    void constructor(Controller c);

    /**
     * method to receive clock information
     */
    void getClock();
}
