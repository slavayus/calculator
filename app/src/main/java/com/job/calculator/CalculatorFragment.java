package com.job.calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Fragment for displaying calculator
 */

public class CalculatorFragment extends Fragment {
    private static final String TAG = "CalculatorFragment";
    private static final int MAX_DIGITS = 10;
    private static final char DIGIT_SEPARATOR = ',';
    private long currentNumber;
    private boolean isThereFirstArgument;
    private long result;
    private Operations operation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        setClickListeners(view);


        return view;
    }

    public void setClickListeners(final View view) {
        final TextView textView = view.findViewById(R.id.textView);
        view.findViewById(R.id.one_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber++;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.two_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber += 2;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.three_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber += 3;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.four_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber += 4;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.five_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber += 5;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.six_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber += 6;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.seven_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber += 7;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.eight_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber += 8;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.nine_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(currentNumber).length() < MAX_DIGITS) {
                    currentNumber *= 10;
                    currentNumber += 9;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.minus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = isThereFirstArgument ? result - currentNumber : currentNumber;
                currentNumber = 0;
                operation = Operations.MINUS;
                isThereFirstArgument = true;
                String newText = putComma(result) + "\n" + operation;
                textView.setText(newText);
            }
        });

        view.findViewById(R.id.equal_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation != null) {
                    switch (operation) {
                        case MULL:
                            result += currentNumber;
                            break;
                        case PLUS:
                            result += currentNumber;
                            break;
                        case MINUS:
                            result -= currentNumber;
                            break;
                        case DIVIDE:
                            result /= currentNumber;
                            break;
                    }
                } else {
                    if (!" ".equals(getTextViewLastLine(textView))) {
                        result = currentNumber;
                    }
                }
                operation = null;
                isThereFirstArgument = true;
                currentNumber = 0;
                String newText = putComma(result) + "\n ";
                textView.setText(newText);
            }
        });


    }

    private String getTextViewLastLine(TextView textView) {
        String lines[] = textView.getText().toString().split("\\r?\\n");
        return lines[lines.length - 1];
    }

    private void updateTextView(TextView textView) {
        String newText = getTextViewTextWithoutLastLine(textView) + (isThereFirstArgument && operation != null ? operation : "") + " " + putComma(currentNumber);
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

    private StringBuilder putComma(long number) {
        String text = String.valueOf(number);
        StringBuilder textWithComma = new StringBuilder(text);

        for (int i = text.length() - 3; i > 0; i -= 3) {
            textWithComma.insert(i, DIGIT_SEPARATOR);
        }

        return textWithComma;
    }
}
