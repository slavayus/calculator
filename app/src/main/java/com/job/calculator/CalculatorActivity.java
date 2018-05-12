package com.job.calculator;

import android.support.v4.app.Fragment;

/**
 * App start activity
 */

public class CalculatorActivity extends SingleFragmentActivity {

    /**
     * Creates a new {@link CalculatorFragment}
     *
     * @return a new CalculatorFragment
     */
    @Override
    protected Fragment createFragment() {
        return new CalculatorFragment();
    }
}
