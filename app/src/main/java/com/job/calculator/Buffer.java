package com.job.calculator;

/**
 * Class for working with buffer
 */

final class Buffer {
    private double data;

    Buffer(double data) {
        this.data = data;
    }


    void save(double data) {
        this.data = data;
    }

    double read() {
        return data;
    }

    void clear() {
        data = 0;
    }

    void plus(double data) {
        this.data += data;
    }

    void minus(double data) {
        this.data -= data;
    }
}
