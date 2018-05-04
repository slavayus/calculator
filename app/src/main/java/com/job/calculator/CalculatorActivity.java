package com.job.calculator;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * App start activity
 */

public class CalculatorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CalculatorFragment();
    }
}
