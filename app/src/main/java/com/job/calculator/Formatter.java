package com.job.calculator;

import com.job.calculator.commands.Command;

/**
 * Class for formatting the text
 */

class Formatter {
    private static final char DIGIT_SEPARATOR = ',';
    private static final String SQRT_SIGN = "\u221a";

    static String getAsSin(boolean inDegrees, String currentNumber, double result) {
        return "sin(" + (Math.abs(getCurrentNumberAsNumber(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }

    static String getAsCos(boolean inDegrees, String currentNumber, double result) {
        return "cos(" + (Math.abs(getCurrentNumberAsNumber(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }

    static String getAsTan(boolean inDegrees, String currentNumber, double result) {
        return "tan(" + (Math.abs(getCurrentNumberAsNumber(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }

    static String getAsCtg(boolean inDegrees, String currentNumber, double result) {
        return "ctg(" + (Math.abs(getCurrentNumberAsNumber(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";

    }

    private static String putComma(String number) {
        StringBuilder textWithComma = new StringBuilder(number);
        int lastChar = number.length() > 0 && '-' == (number.charAt(0)) ? 1 : 0;
        int firstChar = number.indexOf('.') != -1 ? number.indexOf('.') - 3 : number.length() - 3;
        for (int i = firstChar; i > lastChar; i -= 3) {
            textWithComma.insert(i, DIGIT_SEPARATOR);
        }

        return textWithComma.toString();
    }

    static String appendChar(String dataInTextView, double result, Command command, String currentNumber) {
        return dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n " +
                (command != null ? command : "") + " " +
                (Math.abs(getCurrentNumberAsNumber(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber));
    }


    static double getCurrentNumberAsNumber(String currentNumber) {
        return "".equals(currentNumber) ? 0 : Double.parseDouble(currentNumber);
    }

    static String getAsNewResult(String dataInTextView, double result, Command command) {
        return dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n" + (command == null ? "" : command);
    }

    static String getAsSqrt(String currentNumber, double result) {
        return SQRT_SIGN + " " + (Math.abs(getCurrentNumberAsNumber(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                "\n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }

    static String getAsSquare(String currentNumber, double result) {
        return (Math.abs(getCurrentNumberAsNumber(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                "\n ^ 2 \n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }

    static String getAsEqual(double previousResult, String currentNumber, double result, Command command) {
        return (Math.abs(previousResult) == Double.POSITIVE_INFINITY ? String.valueOf(previousResult) : putComma(String.valueOf(previousResult))) +
                "\n " + command + " " +
                (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                "\n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }
}
