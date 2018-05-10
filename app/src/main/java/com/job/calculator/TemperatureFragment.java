package com.job.calculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.job.calculator.commands.temperature.Celsius;
import com.job.calculator.commands.temperature.Fahrenheit;
import com.job.calculator.commands.temperature.Kelvin;
import com.job.calculator.commands.temperature.Rankin;
import com.job.calculator.commands.temperature.Remyure;
import com.job.calculator.commands.temperature.Temperature;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Fragment for displaying temperature calculator
 */

public class TemperatureFragment extends Fragment {
    private static final int MAX_DIGITS = 10;
    private String mCurrentNumber = "0";
    private Temperature mOperationFrom;
    private Temperature mOperationTo;
    private String[] mTemperatureTypes;
    private Temperature[] mOperations;
    private DecimalFormat mFormatter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);

        mTemperatureTypes = getResources().getStringArray(R.array.temperature_types);

        createOperations();
        initialiseFormatter();
        mOperationFrom = mOperations[0];
        mOperationTo = mOperations[1];
        setUpListeners(view);

        return view;
    }

    private void initialiseFormatter() {
        mFormatter = new DecimalFormat("#.####");
        mFormatter.setRoundingMode(RoundingMode.CEILING);
        DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
        sym.setDecimalSeparator('.');
        mFormatter.setDecimalFormatSymbols(sym);
    }

    private void createOperations() {
        mOperations = new Temperature[5];
        mOperations[0] = new Celsius();
        mOperations[1] = new Fahrenheit();
        mOperations[2] = new Kelvin();
        mOperations[3] = new Rankin();
        mOperations[4] = new Remyure();
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
                updateTextView(fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.clear_all_tasks_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber = "0";
                updateTextView(fromTextView, toTextView);
            }
        });

        view.findViewById(R.id.minus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"0".equals(mCurrentNumber)) {
                    if (mCurrentNumber.indexOf('-') == -1) {
                        mCurrentNumber = "-" + mCurrentNumber;
                    }
                    updateTextView(fromTextView, toTextView);
                }
            }
        });

        view.findViewById(R.id.plus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentNumber.indexOf('-') != -1) {
                    mCurrentNumber = mCurrentNumber.substring(1, mCurrentNumber.length());
                    updateTextView(fromTextView, toTextView);
                }
            }
        });

        final TextView temperatureFromTextView = view.findViewById(R.id.temperature_type_from);
        final TextView temperatureDescriptionFromTextView = view.findViewById(R.id.temperature_type_description_from);
        temperatureFromTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext() != null) {
                    new AlertDialog.Builder(getContext()).
                            setTitle(R.string.choose_type).
                            setSingleChoiceItems(mTemperatureTypes, -1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    temperatureFromTextView.setText(mTemperatureTypes[i].split(" ")[1]);
                                    temperatureDescriptionFromTextView.setText(mTemperatureTypes[i].split(" ")[0]);
                                    mOperationFrom = mOperations[i];
                                    updateTextView(fromTextView, toTextView);
                                }
                            }).
                            setCancelable(true).
                            create().
                            show();
                }
            }
        });

        final TextView temperatureToTextView = view.findViewById(R.id.temperature_type_to);
        final TextView temperatureDescriptionToTextView = view.findViewById(R.id.temperature_type_description_to);
        temperatureToTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext() != null) {
                    new AlertDialog.Builder(getContext()).
                            setTitle(R.string.choose_type).
                            setSingleChoiceItems(mTemperatureTypes, -1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    temperatureToTextView.setText(mTemperatureTypes[i].split(" ")[1]);
                                    temperatureDescriptionToTextView.setText(mTemperatureTypes[i].split(" ")[0]);
                                    mOperationTo = mOperations[i];
                                    updateTextView(fromTextView, toTextView);
                                }
                            }).
                            setCancelable(true).
                            create().
                            show();
                }
            }
        });
    }

    private void updateTextView(TextView fromTextView, TextView toTextView) {
        fromTextView.setText(Formatter.putComma(mCurrentNumber));
        String text = mFormatter.format(calculate());
        toTextView.setText(Formatter.putComma(text));
    }

    private void doButtonListener(char c, TextView fromTextView, TextView toTextView) {
        appendChar(c);
        fromTextView.setText(Formatter.putComma(mCurrentNumber));
        updateTextView(fromTextView, toTextView);
    }

    private Double calculate() {
        double inCelsius = mOperationFrom.fromCelsius(Double.parseDouble(mCurrentNumber));
        return mOperationTo.toCelsius(inCelsius);
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