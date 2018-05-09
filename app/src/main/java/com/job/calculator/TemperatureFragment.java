package com.job.calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.job.calculator.commands.temperature.Celsius;
import com.job.calculator.commands.temperature.Fahrenheit;
import com.job.calculator.commands.temperature.Temperature;

/**
 * Fragment for displaying temperature calculator
 */

public class TemperatureFragment extends Fragment {
    private static final int MAX_DIGITS = 10;
    private String mCurrentNumber = "0";
    private Temperature mOperationFrom;
    private Temperature mOperationTo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);

        mOperationFrom = new Celsius();
        mOperationTo = new Fahrenheit();
        setUpListeners(view);

        return view;
    }

    public void setUpListeners(View view) {
        final TextView fromTextView = view.findViewById(R.id.temperature_data_from);
        final TextView toTextView = view.findViewById(R.id.temperature_data_to);

        view.findViewById(R.id.zero_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('0', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.one_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('1', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.two_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('2', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.three_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('3', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.four_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('4', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.five_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('5', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.six_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('6', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.seven_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('7', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.eight_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('8', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.nine_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonListener('9', fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.dot_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentNumber.indexOf('.') == -1) {
                    doButtonListener('.', fromTextView, toTextView);
                }
            }
        });

        view.findViewById(R.id.clear_last_char_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"0".equals(mCurrentNumber)) {
                    mCurrentNumber = mCurrentNumber.substring(0, mCurrentNumber.length() - 1);
                }
                if ("".equals(mCurrentNumber) || "-".equals(mCurrentNumber)) {
                    mCurrentNumber = "0";
                }
                fromTextView.setText(mCurrentNumber);
                toTextView.setText(String.valueOf(calculate()));
            }
        });

        view.findViewById(R.id.clear_all_tasks_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber = "0";
                fromTextView.setText(mCurrentNumber);
                toTextView.setText(String.valueOf(calculate()));
            }
        });

        view.findViewById(R.id.minus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"0".equals(mCurrentNumber)) {
                    if (mCurrentNumber.indexOf('-') == -1) {
                        mCurrentNumber = "-" + mCurrentNumber;
                    }
                    fromTextView.setText(mCurrentNumber);
                    toTextView.setText(String.valueOf(calculate()));
                }
            }
        });

        view.findViewById(R.id.plus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentNumber.indexOf('-') != -1) {
                    mCurrentNumber = mCurrentNumber.substring(1, mCurrentNumber.length());
                    fromTextView.setText(mCurrentNumber);
                    toTextView.setText(String.valueOf(calculate()));
                }
            }
        });

    }

    private void doButtonListener(char c, TextView fromTextView, TextView toTextView) {
        appendChar(c);
        fromTextView.setText(mCurrentNumber);
        toTextView.setText(String.valueOf(calculate()));
    }

    private double calculate() {
        double inCelsius = mOperationFrom.toCelsius(Double.parseDouble(mCurrentNumber));
        return mOperationTo.fromCelsius(inCelsius);
    }

    private void appendChar(char c) {
        if ("0".equals(mCurrentNumber) && c != '.') {
            mCurrentNumber = String.valueOf(c);
        } else {
            if (mCurrentNumber.length() < MAX_DIGITS) {
                mCurrentNumber += c;
            }
        }
    }
}