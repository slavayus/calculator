package com.job.calculator;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Test for the TemperatureFragment class
 */
public class TemperatureFragmentInstrumentationTest {

    @Rule
    public ActivityTestRule<TemperatureActivity> mActivityRule = new ActivityTestRule<>(
            TemperatureActivity.class,
            false,
            true);


    @Test(expected = NoMatchingViewException.class)
    public void onCreateView() throws Exception {
        onView(withId(R.id.temperature_type_from))
                .check(matches(isDisplayed()));

        onView(withId(R.id.temperature_data_from))
                .check(matches(isDisplayed()));

        onView(withId(R.id.temperature_type_description_from))
                .check(matches(isDisplayed()));

        onView(withId(R.id.temperature_type_to))
                .check(matches(isDisplayed()));

        onView(withId(R.id.temperature_data_to))
                .check(matches(isDisplayed()));

        onView(withId(R.id.temperature_type_description_to))
                .check(matches(isDisplayed()));

        onView(withId(R.id.seven_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.eight_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.nine_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.clear_all_tasks_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.four_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.five_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.six_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.clear_last_char_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.one_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.two_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.three_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.plus_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.zero_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.dot_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.minus_button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.textView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void buttonsTest() throws Exception {
        onView(withId(R.id.zero_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("0")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("32")));

        onView(withId(R.id.zero_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("0")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("32")));

        onView(withId(R.id.zero_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("0")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("32")));


        onView(withId(R.id.one_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("1")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("33.8")));

        onView(withId(R.id.two_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("12")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("53.6")));

        onView(withId(R.id.three_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("123")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("253.4")));

        onView(withId(R.id.four_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("1,234")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("2,253.2")));

        onView(withId(R.id.five_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("12,345")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("22,253")));

        onView(withId(R.id.six_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("123,456")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("222,252.8")));

        onView(withId(R.id.seven_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("1,234,567")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("2,222,252.6")));

        onView(withId(R.id.eight_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("12,345,678")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("22,222,252.4")));

        onView(withId(R.id.nine_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("123,456,789")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("222,222,252.2")));
    }

    @Test
    public void clearLastCharTest() throws Exception {
        onView(withId(R.id.one_button))
                .perform(click());
        onView(withId(R.id.two_button))
                .perform(click());
        onView(withId(R.id.three_button))
                .perform(click());
        onView(withId(R.id.four_button))
                .perform(click());

        onView(withId(R.id.clear_last_char_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("123")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("253.4")));

        onView(withId(R.id.clear_last_char_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("12")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("53.6")));

        onView(withId(R.id.clear_last_char_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("1")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("33.8")));

        onView(withId(R.id.clear_last_char_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("0")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("32")));
    }

    @Test
    public void plusMinusTest() throws Exception {
        onView(withId(R.id.four_button))
                .perform(click());
        onView(withId(R.id.four_button))
                .perform(click());
        onView(withId(R.id.four_button))
                .perform(click());
        onView(withId(R.id.four_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("4,444")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("8,031.2")));

        onView(withId(R.id.plus_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("4,444")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("8,031.2")));

        onView(withId(R.id.minus_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("-4,444")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("-7,967.2")));

        onView(withId(R.id.plus_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("4,444")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("8,031.2")));


        onView(withId(R.id.clear_last_char_button))
                .perform(click());

        onView(withId(R.id.clear_all_tasks_button))
                .perform(click());

        onView(withId(R.id.minus_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("0")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("32")));

        onView(withId(R.id.plus_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("0")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("32")));
    }

    @Test
    public void dotTest() throws Exception {
        onView(withId(R.id.four_button))
                .perform(click());
        onView(withId(R.id.four_button))
                .perform(click());
        onView(withId(R.id.four_button))
                .perform(click());
        onView(withId(R.id.four_button))
                .perform(click());

        onView(withId(R.id.dot_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("4,444.")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("8,031.2")));

        onView(withId(R.id.dot_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("4,444.")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("8,031.2")));

        onView(withId(R.id.dot_button))
                .perform(click());

        onView(withId(R.id.dot_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("4,444.")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("8,031.2")));

        onView(withId(R.id.four_button))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("4,444.4")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("8,031.92")));
    }

    @Test
    public void changeScale() throws Exception {
        onView(withId(R.id.temperature_type_description_from))
                .check(matches(withText("Цельсий")));

        onView(withId(R.id.temperature_type_description_to))
                .check(matches(withText("Фаренгейт")));

        onView(withId(R.id.temperature_type_from))
                .perform(click());

        onView(withText(R.string.choose_type))
                .check(matches(isDisplayed()));

        Context targetContext = InstrumentationRegistry.getTargetContext();
        String[] mTemperatureTypes = targetContext.getResources().getStringArray(R.array.temperature_types);

        for (String mTemperatureType : mTemperatureTypes) {
            onView(withText(mTemperatureType))
                    .check(matches(isDisplayed()));
        }

        onView(withText(mTemperatureTypes[2]))
                .perform(click());

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("0")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("-459.67")));

        onView(withId(R.id.temperature_type_description_from))
                .check(matches(withText("Кельвин")));

        onView(withId(R.id.temperature_type_description_to))
                .check(matches(withText("Фаренгейт")));


        onView(withId(R.id.temperature_type_to))
                .perform(click());

        onView(withText(R.string.choose_type))
                .check(matches(isDisplayed()));

        for (String mTemperatureType : mTemperatureTypes) {
            onView(withText(mTemperatureType))
                    .check(matches(isDisplayed()));
        }

        onView(withText(mTemperatureTypes[3]))
                .perform(click());

        onView(withId(R.id.temperature_type_description_from))
                .check(matches(withText("Кельвин")));

        onView(withId(R.id.temperature_type_description_to))
                .check(matches(withText("Ранкин")));

        onView(withId(R.id.temperature_data_from))
                .check(matches(withText("0")));

        onView(withId(R.id.temperature_data_to))
                .check(matches(withText("0")));
    }
}