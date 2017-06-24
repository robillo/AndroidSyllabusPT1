package com.appbusters.robinkamboj.udacitysyllabuspart1;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.views.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainScreen {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void clickAddButtonInMain() throws Exception {
        onView(withId(R.id.navigation)).perform(click());
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
    }

}
