package com.job.calculator;

import android.support.v4.app.Fragment;

/**
 * App start activity
 */

public class CalculatorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CalculatorFragment();
    }
}
