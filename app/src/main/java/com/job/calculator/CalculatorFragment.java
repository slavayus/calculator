package com.job.calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Fragment for displaying calculator
 */

public class CalculatorFragment extends Fragment {
    private static final String TAG = "CalculatorFragment";
    private static final String TASKS = "TASKS";
    private static final int MAX_DIGITS = 10;
    private static final char DIGIT_SEPARATOR = ',';
    private String currentNumber = "";
    private String dataInTextView = "";
    private double result;
    private Operations operation;
    private boolean isThereResult;
    private boolean isThereDot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        if (savedInstanceState != null) {
            dataInTextView = savedInstanceState.getString(TASKS);
        }

        setClickListeners(view);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TASKS, dataInTextView);
    }

    public void setClickListeners(final View view) {
        final TextView textView = view.findViewById(R.id.textView);

        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.append(dataInTextView);

        view.findViewById(R.id.zero_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNumber.length() != 1 || Double.parseDouble(currentNumber) != 0) {
                    appendNewCharToCurrentNumber('0');
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.one_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('1');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.two_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('2');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.three_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('3');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.four_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('4');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.five_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('5');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.six_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('6');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.seven_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('7');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.eight_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('8');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.nine_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNewCharToCurrentNumber('9');
                updateTextView(textView);
            }
        });

        view.findViewById(R.id.dot_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isThereDot) {
                    isThereDot = true;
                    if ("".equals(currentNumber)) {
                        currentNumber = "0";
                    }
                    appendNewCharToCurrentNumber('.');
                    updateTextView(textView);
                }
            }
        });
        view.findViewById(R.id.minus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = operation == null && isThereResult ? Operations.MINUS : operation;

                calculateResult(getCurrentNumberAsNumber());

                currentNumber = "";
                operation = Operations.MINUS;
                String newText = dataInTextView + putComma(String.valueOf(result)) + "\n" + operation;
                textView.setText("");
                textView.append(newText);
            }
        });

        view.findViewById(R.id.plus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = operation == null && isThereResult ? Operations.PLUS : operation;

                calculateResult(getCurrentNumberAsNumber());

                currentNumber = "";
                operation = Operations.PLUS;
                String newText = dataInTextView + putComma(String.valueOf(result)) + "\n" + operation;
                textView.setText("");
                textView.append(newText);
            }
        });

        view.findViewById(R.id.multiply_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = operation == null && isThereResult ? Operations.MULL : operation;

                calculateResult(getCurrentNumberAsNumber());

                currentNumber = "";
                operation = Operations.MULL;
                String newText = dataInTextView + putComma(String.valueOf(result)) + "\n" + operation;
                textView.setText("");
                textView.append(newText);
            }
        });

        view.findViewById(R.id.divide_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = operation == null && isThereResult ? Operations.DIVIDE : operation;

                calculateResult(getCurrentNumberAsNumber());

                currentNumber = "";
                operation = Operations.DIVIDE;
                String newText = dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n" + operation;
                textView.setText("");
                textView.append(newText);
            }
        });

        view.findViewById(R.id.percent_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = operation == null && isThereResult ? Operations.PERCENT : operation;

                calculateResult(getCurrentNumberAsNumber());

                currentNumber = "";
                operation = Operations.PERCENT;
                String newText = dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n" + operation;
                textView.setText("");
                textView.append(newText);
            }
        });

        Button button = view.findViewById(R.id.square_button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operation = null;
                    isThereResult = true;
                    isThereDot = false;
                    if ("".equals(currentNumber)) {
                        currentNumber = String.valueOf(result);
                    }
                    result = Math.pow(Double.parseDouble(currentNumber), 2);

                    dataInTextView += (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? String.valueOf(Double.parseDouble(currentNumber)) : putComma(String.valueOf(Double.parseDouble(currentNumber)))) +
                            "\n ^ 2 \n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";

                    currentNumber = "";
                    String newText = dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n ";
                    textView.setText("");
                    textView.append(newText);
                }
            });
            view.findViewById(R.id.cube_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operation = null;
                    isThereResult = true;
                    isThereDot = false;
                    if ("".equals(currentNumber)) {
                        currentNumber = String.valueOf(result);
                    }
                    result = Math.pow(Double.parseDouble(currentNumber), 3);

                    dataInTextView += (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? String.valueOf(Double.parseDouble(currentNumber)) : putComma(String.valueOf(Double.parseDouble(currentNumber)))) +
                            "\n ^ 3 \n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";

                    currentNumber = "";
                    String newText = dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n ";
                    textView.setText("");
                    textView.append(newText);
                }
            });

            view.findViewById(R.id.random_exponent_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operation = operation == null && isThereResult ? Operations.RANDOM_EXPONENT : operation;

                    calculateResult(getCurrentNumberAsNumber());

                    currentNumber = "";
                    operation = Operations.RANDOM_EXPONENT;
                    String newText = dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n" + operation;
                    textView.setText("");
                    textView.append(newText);
                }
            });
        }

        view.findViewById(R.id.clear_last_char_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(currentNumber)) {
                    String newNumber = currentNumber.substring(0, currentNumber.length() - 1);
                    if (".".equals(currentNumber.substring(currentNumber.length() - 1, currentNumber.length()))) {
                        isThereDot = false;
                    }
                    currentNumber = "0".equals(newNumber) ? "" : newNumber;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.clear_all_tasks_buton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                currentNumber = "";
                isThereDot = false;
                isThereResult = false;
                operation = null;
                dataInTextView = "";
                textView.setText("");
                textView.append(" ");
            }
        });

        view.findViewById(R.id.clear_last_task_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                currentNumber = "";
                isThereDot = false;
                isThereResult = false;
                operation = null;
                textView.setText("");
                textView.append(dataInTextView);
            }
        });


        view.findViewById(R.id.equal_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number = getCurrentNumberAsNumber();

                double previousResult = result;

                if (!"".equals(currentNumber)) {
                    calculateResult(number);
                }

                if (operation == null && !" ".equals(getTextViewLastLine(textView))) {
                    result = number;
                } else {
                    if (operation != null && !"".equals(currentNumber)) {
                        dataInTextView += (Math.abs(previousResult) == Double.POSITIVE_INFINITY ? String.valueOf(previousResult) : putComma(String.valueOf(previousResult))) +
                                "\n " + operation + " " +
                                (Math.abs(Double.parseDouble(currentNumber)) == Double.POSITIVE_INFINITY ? currentNumber : putComma(currentNumber)) +
                                "\n = " + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n\n ";
                    }
                }

                operation = null;
                currentNumber = "";
                String newText = dataInTextView + (Math.abs(result) == Double.POSITIVE_INFINITY ? String.valueOf(result) : putComma(String.valueOf(result))) + "\n ";
                textView.setText("");
                textView.append(newText);
            }
        });

    }

    private void appendNewCharToCurrentNumber(char newChar) {
        if (currentNumber.length() < MAX_DIGITS) {
            currentNumber += newChar;
            isThereResult = operation != null;
        }
    }

    private void calculateResult(double number) {
        if (operation != null) {
            switch (operation) {
                case MULL:
                    result *= number + ("".equals(currentNumber) ? 1 : 0);
                    break;
                case PLUS:
                    result += number;
                    break;
                case MINUS:
                    result -= number;
                    break;
                case DIVIDE:
                    result /= number + ("".equals(currentNumber) ? 1 : 0);
                    break;
                case PERCENT:
                    result = result * (number + ("".equals(currentNumber) ? 100 : 0)) / 100;
                case RANDOM_EXPONENT:
                    result = Math.pow(result, (number + ("".equals(currentNumber) ? 1 : 0)));
            }
        } else {
            result = number;
        }
        isThereDot = false;
        isThereResult = true;
    }

    private String getTextViewLastLine(TextView textView) {
        String lines[] = textView.getText().toString().split("\\r?\\n");
        return lines[lines.length - 1];
    }

    private void updateTextView(TextView textView) {
        String newText = getTextViewTextWithoutLastLine(textView) + (operation != null ? operation : "") + " " + putComma(currentNumber);
        textView.setText(newText);
    }

    private String getTextViewTextWithoutLastLine(TextView textView) {
        String[] text = textView.getText().toString().split("\\r?\\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length - 1; i++) {
            stringBuilder.append(text[i]).append("\n");
        }
        return stringBuilder.toString();
    }

    private String putComma(String number) {
        StringBuilder textWithComma = new StringBuilder(number);
        int lastChar = number.length() > 0 && '-' == (number.charAt(0)) ? 1 : 0;
        int firstChar = number.indexOf('.') != -1 ? number.indexOf('.') - 3 : number.length() - 3;
        for (int i = firstChar; i > lastChar; i -= 3) {
            textWithComma.insert(i, DIGIT_SEPARATOR);
        }

        return textWithComma.toString();
    }

    public double getCurrentNumberAsNumber() {
        return "".equals(currentNumber) ? 0 : Double.parseDouble(currentNumber);
    }
}