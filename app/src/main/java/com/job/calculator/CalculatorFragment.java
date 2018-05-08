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

import static com.job.calculator.Formatter.getCurrentNumberAsNumber;

/**
 * Fragment for displaying calculator
 */

public class CalculatorFragment extends Fragment {
    private static final String TAG = "CalculatorFragment";
    private static final String MATH_PI = "3.141592";
    private static final String MATH_E = "2.718281";
    private static final String TASKS = "TASKS";
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

        if (savedInstanceState != null) {
            dataInTextView = savedInstanceState.getString(TASKS);
        }

        mBuffer = new Buffer(0);
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
        if (isThereResult) {
            command = comm;
        }
        calculateResult(getCurrentNumberAsNumber(currentNumber) + addToCurrentNumber);
        command = comm;
        updateStateAfterOperation(textView);
    }

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

    private void updateStateAfterOperation(TextView textView) {
        currentNumber = "";
        textView.setText("");
        textView.append(Formatter.getAsNewResult(dataInTextView, result, command));
    }

    private boolean inDegrees(View view) {
        Switch degreeSwitcher = view.findViewById(R.id.degree_switch_button);
        return degreeSwitcher.isChecked();
    }


    private void calculateResult(double number) {
        result = command != null ? command.execute(result, number) : number;
        isThereResult = true;
    }

    private void updateTextView(TextView textView) {
        textView.setText("");
        textView.append(Formatter.appentText(dataInTextView, result, command, currentNumber));
    }
}