package com.job.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Abstract activity to starting transactions for fragments
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    public static final String THEME = "THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(getSavedTheme());

        setContentView(R.layout.activity_fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.calculator_container);
        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.calculator_container, fragment)
                    .commit();
        }
    }

    public int getSavedTheme() {
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        return preferences.getInt(THEME, R.style.LightTheme);
    }
}
