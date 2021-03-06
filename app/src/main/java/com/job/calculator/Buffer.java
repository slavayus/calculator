package com.job.calculator;

/**
 * Class for working with buffer
 */

final class Buffer {
    private double mData;

    /**
     * Constructor with argument.
     *
     * @param data default value
     */
    Buffer(double data) {
        this.mData = data;
    }

    /**
     * Save a new value
     *
     * @param data a new value for saving
     */
    void save(double data) {
        this.mData = data;
    }

    /**
     * Read the data from the store
     *
     * @return stored value
     */
    double read() {
        return mData;
    }

    /**
     * Clear the stored value. Sets the value to 0.
     */
    void clear() {
        mData = 0;
    }

    /**
     * Add a new data to saved value.
     *
     * @param data a value for adding
     */
    void plus(double data) {
        this.mData += data;
    }

    /**
     * Subtracts a data from the stored value
     *
     * @param data a value for subtracting
     */
    void minus(double data) {
        this.mData -= data;
    }
}
