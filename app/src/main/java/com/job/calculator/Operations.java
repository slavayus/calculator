package com.job.calculator;

/**
 * Operations with numbers
 */

public enum Operations {
    MULL {
        @Override
        public String toString() {
            return "*";
        }
    }, DIVIDE {
        @Override
        public String toString() {
            return "/";
        }
    }, MINUS {
        @Override
        public String toString() {
            return "-";
        }
    }, PLUS {
        @Override
        public String toString() {
            return "+";
        }
    }, PERCENT {
        @Override
        public String toString() {
            return "%";
        }
    }
}
