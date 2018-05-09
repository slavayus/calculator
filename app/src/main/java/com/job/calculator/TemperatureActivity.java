package com.job.calculator;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Activity for displaying temperature fragment
 */

public class TemperatureActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TemperatureFragment();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, TemperatureActivity.class);
    }


}
