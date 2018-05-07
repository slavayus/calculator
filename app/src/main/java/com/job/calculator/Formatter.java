package com.job.calculator;

/**
 * Class for formatting the text
 */

class Formatter {
    private static final char DIGIT_SEPARATOR = ',';

    static String getAsSin(boolean inDegrees, String currentNumber, double result) {
        return "sin(" + (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? String.valueOf(Double.parseDouble(currentNumber)) : putComma(String.valueOf(Double.parseDouble(currentNumber)))) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }

    static String getAsCos(boolean inDegrees, String currentNumber, double result) {
        return "cos(" + (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? String.valueOf(Double.parseDouble(currentNumber)) : putComma(String.valueOf(Double.parseDouble(currentNumber)))) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }

    static String getAsTan(boolean inDegrees, String currentNumber, double result) {
        return "tan(" + (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? String.valueOf(Double.parseDouble(currentNumber)) : putComma(String.valueOf(Double.parseDouble(currentNumber)))) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
    }

    static String getAsCtg(boolean inDegrees, String currentNumber, double result) {
        return "ctg(" + (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? String.valueOf(Double.parseDouble(currentNumber)) : putComma(String.valueOf(Double.parseDouble(currentNumber)))) +
                (inDegrees ? "\u00B0" : "") + ")\n = " +
                (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";

    }

    static String putComma(String number) {
        StringBuilder textWithComma = new StringBuilder(number);
        int lastChar = number.length() > 0 && '-' == (number.charAt(0)) ? 1 : 0;
        int firstChar = number.indexOf('.') != -1 ? number.indexOf('.') - 3 : number.length() - 3;
        for (int i = firstChar; i > lastChar; i -= 3) {
            textWithComma.insert(i, DIGIT_SEPARATOR);
        }

        return textWithComma.toString();
    }
}
