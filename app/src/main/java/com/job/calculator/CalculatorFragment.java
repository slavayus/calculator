package com.job.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.job.calculator.commands.one.CommandWIthSingleArgument;
import com.job.calculator.commands.one.SqrtCommand;
import com.job.calculator.commands.one.SquareCommand;
import com.job.calculator.commands.one.trigonometric.CosCommand;
import com.job.calculator.commands.one.trigonometric.CtgCommand;
import com.job.calculator.commands.one.trigonometric.SinCommand;
import com.job.calculator.commands.one.trigonometric.TanCommand;
import com.job.calculator.commands.two.CommandWithTwoArgument;
import com.job.calculator.commands.two.DivideCommand;
import com.job.calculator.commands.two.MinusCommand;
import com.job.calculator.commands.two.MullCommand;
import com.job.calculator.commands.two.PercentCommand;
import com.job.calculator.commands.two.PlusCommand;
import com.job.calculator.commands.two.RandomExponentCommand;

import static com.job.calculator.CalculatorActivity.THEME;
import static com.job.calculator.Formatter.getCurrentNumberAsNumber;

/**
 * Fragment for displaying calculator
 */

public class CalculatorFragment extends Fragment {
    private static final String TAG = "CalculatorFragment";
    private static final String BUFFER = "BUFFER";
    private static final String TASKS = "TASKS";
    private static final String RESULT = "RESULT";
    private static final String MATH_PI = "3.141592";
    private static final String MATH_E = "2.718281";
    private static final int MAX_DIGITS = 10;
    private String currentNumber = "";
    private String dataInTextView = "";
    private double result;
    private CommandWithTwoArgument command;
    private boolean isThereResult;
    private Buffer mBuffer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        loadData();

        setClickListeners(view);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.calculator_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.change_theme:
                Log.d(TAG, "onOptionsItemSelected: in change theme");
                if (getActivity() != null) {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    int currentTheme = preferences.getInt(THEME, R.style.LightTheme);
                    SharedPreferences.Editor edit = preferences.edit();
                    edit.putInt(THEME, currentTheme == R.style.DarkTheme ? R.style.LightTheme : R.style.DarkTheme);
                    edit.apply();
                    getActivity().recreate();
                    Log.d(TAG, "onOptionsItemSelected: theme changed");
                }
                return true;
            case R.id.calculate_temperature:
                startActivity(TemperatureActivity.newIntent(getActivity()));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadData() {
        mBuffer = new Buffer(0);
        if (getActivity() != null) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            mBuffer.save(Double.parseDouble(preferences.getString(BUFFER, "0")));
            dataInTextView = preferences.getString(TASKS, "");
            result = Double.parseDouble(preferences.getString(RESULT, "0"));
            isThereResult = true;
            Log.d(TAG, "loadData: data loaded");
        }
    }

    /**
     * Fragment lifecycle method.
     * Saves the result in SharedPreferences
     */
    @Override
    public void onStop() {
        super.onStop();
        if (getActivity() != null) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            SharedPreferences.Editor edit = preferences.edit();
            edit.putString(BUFFER, String.valueOf(mBuffer.read()));
            edit.putString(TASKS, dataInTextView);
            edit.putString(RESULT, String.valueOf(result));
            edit.apply();
            Log.d(TAG, "onDestroy: data saved");
        }
    }

    /**
     * Sets up listeners for buttons
     *
     * @param view where the buttons are located
     */
    public void setClickListeners(final View view) {
        final TextView textView = view.findViewById(R.id.textView);

        textView.setMovementMethod(new ScrollingMovementMethod());
        updateTextView(textView);

        view.findViewById(R.id.zero_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('0', textView);
            }
        });

        view.findViewById(R.id.one_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('1', textView);
            }
        });

        view.findViewById(R.id.two_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('2', textView);
            }
        });

        view.findViewById(R.id.three_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('3', textView);
            }
        });

        view.findViewById(R.id.four_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('4', textView);
            }
        });

        view.findViewById(R.id.five_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('5', textView);
            }
        });

        view.findViewById(R.id.six_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('6', textView);
            }
        });

        view.findViewById(R.id.seven_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('7', textView);
            }
        });

        view.findViewById(R.id.eight_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('8', textView);
            }
        });

        view.findViewById(R.id.nine_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeCurrentNumberAndUpdateState('9', textView);
            }
        });

        view.findViewById(R.id.dot_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNumber.indexOf('.') == -1) {
                    if ("".equals(currentNumber)) {
                        currentNumber = "0";
                    }
                    changeCurrentNumberAndUpdateState('.', textView);
                }
            }
        });

        view.findViewById(R.id.minus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperation(new MinusCommand(), 0, textView);
            }
        });

        view.findViewById(R.id.plus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperation(new PlusCommand(), 0, textView);
            }
        });

        view.findViewById(R.id.multiply_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperation(new MullCommand(), "".equals(currentNumber) ? 1 : 0, textView);
            }
        });

        view.findViewById(R.id.divide_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOperation(new DivideCommand(), "".equals(currentNumber) ? 1 : 0, textView);
            }
        });

        view.findViewById(R.id.sqrt_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSingleArgument(new SqrtCommand(), textView);
            }
        });

        final Button button = view.findViewById(R.id.square_button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateSingleArgument(new SquareCommand(), textView);
                }
            });

            view.findViewById(R.id.random_exponent_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doOperation(new RandomExponentCommand(), "".equals(currentNumber) ? 1 : 0, textView);
                }
            });

            view.findViewById(R.id.percent_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doOperation(new PercentCommand(), "".equals(currentNumber) ? 100 : 0, textView);
                }
            });

            view.findViewById(R.id.sin_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateSingleArgument(new SinCommand(inDegrees(view)), textView);
                }
            });

            view.findViewById(R.id.cos_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateSingleArgument(new CosCommand(inDegrees(view)), textView);
                }
            });

            view.findViewById(R.id.tan_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateSingleArgument(new TanCommand(inDegrees(view)), textView);
                }
            });

            view.findViewById(R.id.ctg_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateSingleArgument(new CtgCommand(inDegrees(view)), textView);
                }
            });


            view.findViewById(R.id.pi_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentNumber = MATH_PI;
                    isThereResult = command != null;
                    updateTextView(textView);
                }
            });

            view.findViewById(R.id.e_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentNumber = MATH_E;
                    isThereResult = command != null;
                    updateTextView(textView);
                }
            });

            view.findViewById(R.id.ms_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBuffer.save(result);
                }
            });

            view.findViewById(R.id.mr_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    result = mBuffer.read();
                    updateTextView(textView);
                }
            });

            view.findViewById(R.id.mc_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBuffer.clear();
                }
            });

            view.findViewById(R.id.mplus_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBuffer.plus(result);
                }
            });

            view.findViewById(R.id.mminus_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBuffer.minus(result);
                }
            });
        }

        view.findViewById(R.id.clear_last_char_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(currentNumber)) {
                    currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                    isThereResult = true;
                    updateTextView(textView);
                }
            }
        });

        view.findViewById(R.id.clear_all_tasks_buton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                currentNumber = "";
                isThereResult = false;
                command = null;
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
                isThereResult = false;
                command = null;
                textView.setText("");
                textView.append(dataInTextView);
            }
        });


        view.findViewById(R.id.equal_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number = getCurrentNumberAsNumber(currentNumber);

                double previousResult = result;

                if (!"".equals(currentNumber)) {
                    calculateResult(number);
                }

                if (command == null && !"".equals(currentNumber)) {
                    result = number;
                } else {
                    if (command != null && !"".equals(currentNumber)) {
                        dataInTextView += Formatter.getAsEqual(previousResult, currentNumber, result, command);
                    }
                }

                command = null;
                updateStateAfterOperation(textView);
            }
        });

    }

    /**
     * Calculate result with new data. Execute commands with one arguments
     *
     * @param comm     the command which will calculate
     * @param textView the {@link TextView} where result will be displayed
     * @see CommandWIthSingleArgument
     */
    private void calculateSingleArgument(CommandWIthSingleArgument comm, TextView textView) {
        command = null;
        isThereResult = true;
        if ("".equals(currentNumber)) {
            currentNumber = String.valueOf(result);
        }
        result = comm.execute(getCurrentNumberAsNumber(currentNumber));
        dataInTextView += comm;
        updateStateAfterOperation(textView);
    }

    private void doOperation(CommandWithTwoArgument comm, int addToCurrentNumber, TextView textView) {
        if (command == null && isThereResult) {
            command = comm;
        }
        if (!"".equals(currentNumber)) {
            calculateResult(getCurrentNumberAsNumber(currentNumber) + addToCurrentNumber);
        }
        command = comm;
        updateStateAfterOperation(textView);
    }

    /**
     * Listener for buttons. Add a new char to current number.
     *
     * @param c        new symbol according on typing the digit buttons
     * @param textView the {@link TextView} where current number will be updated
     */
    private void changeCurrentNumberAndUpdateState(char c, TextView textView) {
        if ("0".equals(currentNumber) && c != '.') {
            currentNumber = String.valueOf(c);
        } else {
            if (currentNumber.length() < MAX_DIGITS) {
                currentNumber += c;
            }
        }
        isThereResult = command != null;
        updateTextView(textView);
    }

    /**
     * Updates the {@link TextView} with new data.
     *
     * @param textView which will be updated.
     */
    private void updateStateAfterOperation(TextView textView) {
        currentNumber = "";
        textView.setText("");
        textView.append(Formatter.getAsNewResult(dataInTextView, result, command));
    }

    /**
     * Check if the degree button is pressed.
     *
     * @param view where the degree button is located
     * @return true - it will be calculated in degrees
     * false - it will be calculated in radians
     */
    private boolean inDegrees(View view) {
        Switch degreeSwitcher = view.findViewById(R.id.degree_switch_button);
        return degreeSwitcher.isChecked();
    }


    /**
     * Executes the selected command
     *
     * @param number current number which will be calculated
     */
    private void calculateResult(double number) {
        result = command != null ? command.execute(result, number) : number;
        isThereResult = true;
    }

    /**
     * Updates the {@link TextView} with new data.
     *
     * @param textView which will be updated.
     */
    private void updateTextView(TextView textView) {
        textView.setText("");
        textView.append(Formatter.appendText(dataInTextView, result, command, currentNumber));
    }
}