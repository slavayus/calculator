package com.job.calculator;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Activity for displaying temperature fragment
 */

public class TemperatureActivity extends SingleFragmentActivity {

    /**
     * Creates a new {@link TemperatureFragment}
     *
     * @return a new TemperatureFragment
     */
    @Override
    protected Fragment createFragment() {
        return new TemperatureFragment();
    }

    /**
     * Creates a new {@link TemperatureActivity}
     *
     * @param context current app context
     * @return a new TemperatureActivity
     */
    public static Intent newIntent(Context context) {
        return new Intent(context, TemperatureActivity.class);
    }
}
